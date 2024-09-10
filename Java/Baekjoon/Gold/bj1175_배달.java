package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1175_배달 {
    static int N, M;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int[][] end = new int[2][2];
        int eIndex = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[1 << 2][5][N][M]; // 배달 상태, 방향, 방문 처리
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') q.add(new int[]{i, j, 4, 0}); // y, x, 이전 방향, 배달 상태
                else if (map[i][j] == 'C') end[eIndex++] = new int[]{i, j};
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] p = q.poll();
                for (int i = 0; i < 4; i++) {
                    if (p[2] == i) continue;
                    int ny = p[0] + dy[i];
                    int nx = p[1] + dx[i];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == '#' || visited[p[3]][i][ny][nx]) continue;
                    visited[p[3]][i][ny][nx] = true;
                    boolean flag = true;
                    for (int j = 0; j < 2; j++) {
                        if (end[j][0] == ny && end[j][1] == nx) {
                            int np = p[3] | 1 << j;
                            flag = false;
                            if (np == 3) {
                                System.out.println(cnt);
                                return;
                            }
                            visited[np][i][ny][nx] = true;
                            q.add(new int[]{ny, nx, i, np});
                        }
                    }
                    if (flag)q.add(new int[]{ny, nx, i, p[3]});
                }
            }
        }
        System.out.println(-1);
    }
}
