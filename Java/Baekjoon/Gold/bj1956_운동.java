package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1956_운동 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] map = new int[V + 1][V + 1];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i <= V; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = Integer.parseInt(st.nextToken());
        }

        int ans = INF;
        for (int m = 1; m <= V; m++)
            for (int s = 1; s <= V; s++) {
                if (map[s][m] == INF || s == m) continue;
                for (int e = 1; e <= V; e++) {
                    if (map[m][e] == INF || m == e) continue;
                    map[s][e] = Math.min(map[s][e], map[s][m] + map[m][e]);
                }
            }

        for (int i = 1; i <= V; i++)
            for (int j = i + 1; j <= V; j++)
                if (map[i][j] != INF && map[j][i] != INF) ans = Math.min(ans, map[i][j] + map[j][i]);

        if (ans == INF) System.out.println(-1);
        else System.out.println(ans);
    }
}
