package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2610_회의준비 {
    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int INF = Integer.MAX_VALUE;
        parents = new int[N + 1];
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set(x, y);
            map[x][y] = 1;
            map[y][x] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (map[j][i] == INF || map[i][k] == INF) continue;
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }
        int[] count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != INF) count[i] = Integer.max(map[i][j], count[i]);
            }
        }
        int cnt = 0;
        boolean[] visited = new boolean[N + 1];
        int[][] result = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(result[i], INF);
        }
        for (int i = 1; i <= N; i++) {
            int p = find(i);
            if (!visited[p]) {
                visited[p] = true;
                cnt++;
            }
            if (result[p][0] > count[i]) {
                result[p][0] = count[i];
                result[p][1] = i;
            }
        }
        Arrays.sort(result, Comparator.comparingInt(o -> o[1]));
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (int i = 0; i <= N; i++) {
            if (result[i][1] == INF) break;
            sb.append(result[i][1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void set(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp < yp) parents[yp] = xp;
        else parents[xp] = yp;
    }
}