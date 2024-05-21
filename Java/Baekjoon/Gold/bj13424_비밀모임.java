package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj13424_비밀모임 {
    static int N, M, T, K, ans, min, INF = Integer.MAX_VALUE;
    static int[] target;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            ans = 0;
            min = INF;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N + 1][N + 1];
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    map[i][j] = i == j ? 0 : INF;
                }
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                map[a][b] = cost;
                map[b][a] = cost;
            }
            floydWarshall();
            K = Integer.parseInt(br.readLine());
            target = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                target[i] = Integer.parseInt(st.nextToken());
            }
            findAns();
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void floydWarshall() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                for (int k = 1; k <= N; k++) {
                    if (i == k || j == k || map[j][i] == INF || map[i][k] == INF) continue;
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }
    }

    static void findAns() {
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 0; j < K; j++) {
                sum += map[target[j]][i];
            }
            if (min > sum) {
                min = sum;
                ans = i;
            }
        }
    }
}
