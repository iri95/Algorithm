package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2206_벽부수고이동하기 {
    static int N, M;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static int[][][] result;
    static boolean[][][] visit;
    static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        result = new int[N + 1][M + 1][2];
        visit = new boolean[N + 1][M + 1][2];
        result[1][1][0] = 1;
        visit[1][1][0] = true;
        for (int i = 1; i <= N; i++) {
            String a = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Character.getNumericValue(a.charAt(j-1));
            }
        }
        queue.offer(new int[]{1, 1, 0});
        bfs();
        int answer = -1;
        if(result[N][M][0] != 0 && result[N][M][1] != 0) {
            answer = Math.min(result[N][M][0], result[N][M][1]);
        }else if(result[N][M][0] != 0 ){
            answer = result[N][M][0];
        }else if(result[N][M][1] != 0 ){
            answer = result[N][M][1];
        }
        System.out.println(answer);
    }

    static void bfs() {
        int cnt = 1;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    int crush = p[2];
                    if (nx <= 0 || ny <= 0 || ny > N || nx > M || visit[ny][nx][crush]) continue;
                    if (crush == 0) {
                        if (map[ny][nx] == 1) {
                            crush = 1;
                            result[ny][nx][crush] = cnt;
                            visit[ny][nx][crush] = true;
                            queue.offer(new int[] {ny, nx, crush});
                        } else {
                            result[ny][nx][crush] = cnt;
                            visit[ny][nx][crush] = true;
                            queue.offer(new int[] {ny, nx, crush});
                        }
                    } else {
                        if (map[ny][nx] == 1) {
                            continue;
                        } else {
                            result[ny][nx][crush] = cnt;
                            visit[ny][nx][crush] = true;
                            queue.offer(new int[] {ny, nx, crush});
                        }
                    }
                }
            }
        }

    }

}
