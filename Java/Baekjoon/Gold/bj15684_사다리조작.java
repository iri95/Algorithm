package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15684_사다리조작 {
    static int N, H, answer = 4;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new boolean[H + 1][N + 2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = true;
        }
        dfs(1, 1, 0);
        if (answer > 3) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void dfs(int row, int column, int cnt) {
        if (pass()) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (cnt >= 3 || cnt >= answer) return;

        for (int i = row; i <= H; i++) {
            for (int j = row == i ? column : 1; j < N; j++) {
                if (!map[i][j] && !map[i][j + 1] && !map[i][j - 1]) {
                    map[i][j] = true;
                    dfs(i, j, cnt + 1);
                    map[i][j] = false;
                }
            }
        }
    }

    private static boolean pass() {
        for (int i = 1; i <= N; i++) {
            int column = i;

            for (int j = 1; j <= H; j++) {
                if (map[j][column]) column++;
                else if (column > 1 && map[j][column - 1]) column--;
            }
            if (i != column) return false;
        }
        return true;
    }
}
