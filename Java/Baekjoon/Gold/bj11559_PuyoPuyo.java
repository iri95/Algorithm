package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class bj11559_PuyoPuyo {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static char[][] map = new char[12][6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int cnt = 0;
        while (bomb()) {
            down();
            cnt++;
        }
        System.out.println(cnt);
    }

    static boolean bomb() {
        Queue<int[]> queue = new ArrayDeque<>();
        ArrayList<int[]> list = new ArrayList<>();
        boolean result = false;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                char target = map[i][j];
                if (target == '.') continue;
                queue.add(new int[]{i, j});
                list.add(new int[]{i, j});
                boolean[][] visit = new boolean[12][6];
                visit[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] p = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int ny = p[0] + dy[k];
                        int nx = p[1] + dx[k];
                        if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6 || visit[ny][nx]) continue;
                        visit[ny][nx] = true;
                        if(map[ny][nx] == '.')continue;
                        if (map[ny][nx] == target) {
                            queue.add(new int[]{ny, nx});
                            list.add(new int[]{ny, nx});
                        }
                    }
                }
                if (list.size() >= 4) {
                    for (int[] p : list) {
                        map[p[0]][p[1]] = '.';
                    }
                    result = true;
                }
                list.clear();
            }
        }
        return result;
    }

    static void down() {
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '.') continue;
                int y = i;
                while (y < 11) {
                    if (map[y + 1][j] != '.') break;
                    map[y + 1][j] = map[y][j];
                    map[y][j] = '.';
                    y++;
                }
            }
        }
    }
}
