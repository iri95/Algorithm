package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3987_보이저1호 {
    static int N, M, INF = Integer.MAX_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][][] visited;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int PR = Integer.parseInt(st.nextToken()) - 1;
        int PC = Integer.parseInt(st.nextToken()) - 1;
        char direction = '.';
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            visited = new boolean[N][M][4];
            int count = dfs(PR, PC, i, 1);
            if (count > cnt) {
                if (i == 0) direction = 'U';
                else if (i == 1) direction = 'R';
                else if (i == 2) direction = 'D';
                else direction = 'L';
                cnt = count;
            }
        }
        System.out.println(direction);
        if (cnt == INF) System.out.println("Voyager");
        else System.out.println(cnt);
    }

    private static int dfs(int y, int x, int dir, int move) {
        if (visited[y][x][dir]) return INF;
        visited[y][x][dir] = true;
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == 'C') return move;

        if (map[ny][nx] == '/')
            if (dir % 2 == 0) return dfs(ny, nx, dir + 1, move + 1);
            else return dfs(ny, nx, dir - 1, move + 1);
        else if (map[ny][nx] == '\\')
            if (dir % 2 == 0) return dfs(ny, nx, (dir + 3) % 4, move + 1);
            else return dfs(ny, nx, (dir + 1) % 4, move + 1);
        else
            return dfs(ny, nx, dir, move + 1);

    }
}