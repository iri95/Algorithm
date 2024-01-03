package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1113_수영장만들기 {
    static int N, M, sum;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;
    static Queue<int[]> queue = new ArrayDeque<>();     // bfs위한 queue
    static Queue<int[]> queue2 = new ArrayDeque<>();    // bfs후 물을 채울 좌표
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String k = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = k.charAt(j) - '0';
            }
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                bfs(i, j);
            }
        }
        System.out.println(sum);

    }
    // 한 점에서 bfs를 돈다
    static void bfs(int y, int x) {
        int value = map[y][x];
        int min = 10;
        visit = new boolean[N][M];
        queue.offer(new int[]{y, x});
        queue2.offer(new int[]{y, x});
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (visit[ny][nx])continue;
                visit[ny][nx] = true;
                if (ny == 0 || ny >= N - 1 || nx == 0 || nx >= M - 1) { // 경계일 떄
                    if (value >= map[ny][nx]) { // 경계보다 클 경우 queue를 비우고 종료
                        queue.clear();
                        queue2.clear();
                        return;
                    }else{  // 경계보다 작을 경우 벽, min값 비교 대입
                        min = Math.min(map[ny][nx], min);
                    }
                }else{
                    if (value >= map[ny][nx]) { // value가 더 크거나 같을경우 queue에 좌표 넣기
                        queue.offer(new int[]{ny, nx});
                        queue2.offer(new int[]{ny, nx});
                    }else{ // value가 더 작을경우 벽, min값 비교 대입
                        min = Math.min(map[ny][nx], min);
                    }
                }
            }
        }
        add(min);
    }

    // 고립되었다면 벽의 최솟값과 각 값들의 차를 sum에 더한다.
    // 각 값들을 벽의 최솟값으로 변경한다.
    static void add(int min) {
        while (!queue2.isEmpty()) {
            int[] p = queue2.poll();
            sum+= min - map[p[0]][p[1]];
            map[p[0]][p[1]] = min;
        }
    }
}
