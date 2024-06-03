package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2933_미네랄 {
    static int R, C, N;
    static int[] floor;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C];

        for (int i = 0; i < R; i++) {
            map[R - i] = br.readLine().toCharArray();
        }

        N = Integer.parseInt(br.readLine());
        floor = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            floor[i] = Integer.parseInt(st.nextToken());
        }

        for (int n = 0; n < N; n++) {
            shot(floor[n], n % 2);
        }
        for (int i = 0; i < R; i++) {
            System.out.println(String.valueOf(map[R - i]));
        }
    }

    // 화살을 쏜다
    static void shot(int f, int dir) {
        int x = dir * (C - 1);
        visited = new boolean[R + 1][C];
        while (0 <= x && x < C) {
            if (map[f][x] == 'x') {
                map[f][x] = '.';
                int nx = x + dx[dir];
                int np = f + 1;
                int nm = f - 1;
                if (0 <= nx && nx < C && map[f][nx] == 'x' && f != 1) bfs(f, nx); // 날아갈 방향의 bfs
                if (np <= R && map[np][x] == 'x' && !visited[np][x]) bfs(np, x); // 위의 bfs
                if (nm > 1 && map[nm][x] == 'x' && !visited[nm][x]) bfs(nm, x); // 아래의 bfs
                break;
            } else x += dx[dir];
        }
    }

    /*
     * 맞은 부분에서 화살 날아온 반대방향, 위 BFS 돌리고 떨어질 클럭스터가 있다면 떨어뜨린다.
     * 방문처리를 하면서 각 열의 바닥면을 체킹
     * 클러스터의 바닥면들 중 가장 덜 떨어지는 높이만큰 내린다.
     */
    static void bfs(int y, int x) {
        int[] low = new int[C]; // 각 열의 바닥부분 체크
        Arrays.fill(low, R * 2);
        low[x] = y;
        visited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        q.add(new int[]{y, x});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            list.add(p);
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (ny < 1 || ny > R || nx < 0 || nx >= C || map[ny][nx] == '.' || visited[ny][nx]) continue;
                low[nx] = Math.min(ny, low[nx]);
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
        // 떨어질 높이가 가장 낮은 걸 찾아내는 과정
        int high = R;
        for (int i = 0; i < C; i++) {
            if (low[i] > R) continue;
            else if (low[i] == 1) return;
            for (int j = low[i] - 1; j >= 0; j--) {
                if (j == 0 || map[j][i] == 'x') {
                    high = Math.min(low[i] - j - 1, high);
                    break;
                }
            }
        }
        if (high == 0) return;

        for (int[] p : list) {
            map[p[0]][p[1]] = '.';
        }
        for (int[] p : list) {
            map[p[0] - high][p[1]] = 'x';
        }
    }
}