package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj7562_나이트의이동 {
    static int N;
    static int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ry = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            bfs(sy, sx, ry, rx);
        }
        System.out.println(sb);
    }
    static void bfs(int y, int x, int endy, int endx){
        Queue<int[]> queue = new ArrayDeque<>();
        if(y == endy && x == endx) {
            sb.append(0).append("\n");
            return;
        }
        queue.offer(new int[]{y, x});
        visit[y][x] = true;
        int cnt = 0;
        while (true) {
            int size = queue.size();
            cnt++;
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;
                    if (endy == ny && endx == nx) {
                        sb.append(cnt).append("\n");
                        return;
                    }
                    visit[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                }
            }

        }
    }
}
