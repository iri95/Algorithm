package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj11780_플로이드2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        List<Integer>[][] lists = new ArrayList[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                lists[i][j] = new ArrayList<>();


        int max = 100_000_01;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], max);
            map[i][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (map[a][b] == max) lists[a][b].add(a);
            map[a][b] = Math.min(c, map[a][b]);

        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                for (int k = 1; k <= n; k++) {
                    if (j == k || k == i) continue;
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                        lists[j][k] = new ArrayList<>(lists[j][i]);
                        lists[j][k].addAll(lists[i][k]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(map[i][j] == max ? 0 : map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int size = lists[i][j].size();

                if (size > 0) {
                    sb.append(size + 1).append(" ");
                    for (int k = 0; k < size; k++) {
                        sb.append(lists[i][j].get(k)).append(" ");
                    }
                    sb.append(j);
                } else sb.append(size);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
