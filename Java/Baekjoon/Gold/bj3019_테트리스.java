package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3019_테트리스 {
    static int C, P;
    static int[] map;
    static int[] count = {2, 1, 2, 2, 4, 4, 4}; // 블럭 회전시 다른 형태 수
    static int[][] length = {{1, 4}, {2}, {3, 2}, {3, 2}, {3, 2, 3, 2}, {3, 2, 3, 2}, {3, 2, 3, 2}};
    static int[][][] block = {{{0}, {0, 0, 0, 0}},
            {{0, 0}},
            {{0, 0, 1}, {1, 0}},
            {{1, 0, 0}, {0, 1}},
            {{0, 0, 0}, {0, 1}, {1, 0, 1}, {1, 0}},
            {{0, 0, 0}, {0, 0}, {0, 1, 1}, {2, 0}},
            {{0, 0, 0}, {0, 0}, {1, 1, 0}, {0, 2}}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken()) - 1;
        map = new int[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) map[i] = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i < count[P]; i++) {
            int len = length[P][i];
            for (int j = 0; j < C - len + 1; j++) {
                int[] list = new int[len];
                int min = 100;
                for (int k = j; k < j + len; k++) {
                    list[k - j] = map[k];
                    min = Math.min(min, map[k]);
                }
                boolean flag = true;
                for (int k = 0; k < len; k++) {
                    list[k] -= min;
                    if (list[k] != block[P][i][k]) flag = false;
                }
                if (flag) ans++;
            }
        }
        System.out.println(ans);
    }
}
