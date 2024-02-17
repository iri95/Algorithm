package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1981_배열에서이동 {
    static int n;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int max = 0;
        int min = 101;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
                min = Math.min(map[i][j], min);
            }
        }
        int start = 0;
        int end = max - min + 1;
        while (start < end) {
            int mid = (start + end) / 2;
            boolean can = false;
            for (int i = min; i + mid <= max; i++) {
                if (bfs(i, i + mid)) {
                    can = true;
                    break;
                }
            }
            if (can) end = mid;
            else start = mid + 1;
        }
        System.out.println(end);
    }

    static boolean bfs(int min, int max) {
        if (map[0][0] < min || map[0][0] > max) return false;
        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || visit[ny][nx] || map[ny][nx] < min || map[ny][nx] > max)
                    continue;
                if (ny == n -1 && nx == n - 1) return true;
                visit[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
        return false;
    }

}
