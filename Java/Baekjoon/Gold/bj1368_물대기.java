package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1368_물대기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] min = new int[N];
        for (int i = 0; i < N; i++) min[i] = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        long answer = 0;

        for (int i = 0; i < N; i++) {
            int minNode = 0;
            int minCost = 100_001;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && min[j] < minCost) {
                    minNode = j;
                    minCost = min[j];
                }
            }

            visited[minNode] = true;
            answer += min[minNode];

            for (int j = 0; j < N; j++) {
                if (!visited[j] && map[minNode][j] != 0 && min[j] > map[minNode][j])
                    min[j] = map[minNode][j];
            }
        }
        System.out.println(answer);
    }
}