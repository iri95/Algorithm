package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4991_로봇청소기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int N, M, move, full;
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        char[][] map;
        boolean[][][] visited;
        Queue<int[]> q;
        while (true) {
            q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (N == 0 || M == 0) break;
            map = new char[N][M];
            visited = new boolean[N][M][2048];
            int dirty = 0;
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'o') {
                        q.add(new int[]{i, j, 0}); // y, x, move, visited(bit masking)
                        map[i][j] = '.';
                    } else if (map[i][j] == '*') map[i][j] = (char) (dirty++ + '0');

                }
            }
            move = 0;
            full = (int) Math.pow(2, dirty);
            bfs:
            while (!q.isEmpty()) {
                int size = q.size();
                move++;
                while (size-- > 0) {
                    int[] p = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int ny = p[0] + dy[i];
                        int nx = p[1] + dx[i];
                        int visit = p[2];
                        if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == 'x' || visited[ny][nx][visit])
                            continue;
                        if (map[ny][nx] != '.') {
                            visit = visit | (1 << (map[ny][nx] - '0'));
                            if (visit == full - 1) {
                                answer.append(move).append("\n");
                                break bfs;
                            }
                        }
                        visited[ny][nx][visit] = true;
                        q.add(new int[]{ny, nx, visit});
                    }
                }
            }
            if (q.isEmpty()) answer.append(-1).append("\n");
        }
        System.out.println(answer);
    }
}
