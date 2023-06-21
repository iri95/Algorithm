package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1520_내리막길 {
    static int N, M;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] map, cnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cnt = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(cnt[i], -1);
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0, 0));
    }

    static int dfs(int y, int x){
        if (y == N - 1 && x == M - 1) {
            return 1;
        }

        if (cnt[y][x] != -1) {
            return cnt[y][x];
        }

        cnt[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= N || nx >= M || ny < 0 || nx < 0)continue;
            if (map[ny][nx] < map[y][x]) {
                cnt[y][x] += dfs(ny, nx);
            }
        }
        return cnt[y][x];
    }
}
