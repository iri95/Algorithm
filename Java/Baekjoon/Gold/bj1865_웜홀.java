package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// TODO: 벨만 포드로 다시 풀어보기
public class bj1865_웜홀 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[][] map = new int[N + 1][N + 1];
            int INF = 25_000_001;
            for (int i = 0; i <= N; i++) {
                Arrays.fill(map[i], INF);
                map[i][i] = 0;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[a][b] = Math.min(c, map[a][b]);
                map[b][a] = Math.min(c, map[b][a]);
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                map[a][b] = Math.min(-c, map[a][b]);
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        if (map[j][k] > map[j][i] + map[i][k]) {
                            map[j][k] = map[j][i] + map[i][k];
                        }
                    }
                }
            }
            boolean can = false;
            for (int i = 1; i <= N; i++) {
                if (map[i][i] < 0) can = true;
            }
            if (can) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
