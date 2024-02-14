package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj21278_호식이두마리치킨 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 1_000_000_000;
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], max);
            map[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 2;
            map[b][a] = 2;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (map[j][k] > map[j][i] + map[i][k])
                        map[j][k] = map[j][i] + map[i][k];
                }
            }
        }
        int[] house = new int[2];
        int sum = max;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int[] visit = new int[N + 1];
                Arrays.fill(visit, max);
                for (int k = 1; k <= N; k++) {
                    visit[k] = map[i][k];
                }
                for (int k = 1; k <= N; k++) {
                    visit[k] = Math.min(visit[k], map[j][k]);
                }
                int s = 0;
                for (int k = 1; k <= N; k++) {
                    s += visit[k];
                }
                if (sum > s) {
                    sum = s;
                    house[0] = i;
                    house[1] = j;
                }
            }
        }
        System.out.println(house[0] + " " + house[1] + " " + sum);

    }
}
