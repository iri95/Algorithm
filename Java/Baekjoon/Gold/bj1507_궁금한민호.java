package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1507_궁금한민호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i < j) sum += map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                for (int k = j + 1; k < N; k++) {
                    if (i == k || j == k || visited[j][k]) continue;

                    if (map[j][k] == map[j][i] + map[i][k]) {
                        visited[j][k] = true;
                        sum -= map[j][k];
                    }

                    if (map[j][k] > map[j][i] + map[i][k]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
