package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class bj2665_미로만들기 {
    static int n, result;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        int[][] count = new int[n][n];
        result = 2500;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Arrays.fill(count[i], 2500);
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) == '0';
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        count[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (map[ny][nx]) {
                    if (count[ny][nx] > p[2] + 1) {
                        count[ny][nx] = p[2] + 1;
                        queue.offer(new int[]{ny, nx, p[2] + 1});
                    }
                } else {
                    if (count[ny][nx] > p[2]) {
                        count[ny][nx] = p[2];
                        queue.offer(new int[]{ny, nx, p[2]});
                    }
                }
            }
        }
        System.out.println(count[n - 1][n - 1]);
    }
}
