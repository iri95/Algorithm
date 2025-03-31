package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9944_NM보드완주하기 {
    static int N, M, answer, max, INF = 1_000_001;
    static int[] dy = {0, 0, -1, 1}, dx = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 0;
        while (true) {
            T++;
            String str = br.readLine();
            if (str == null) break;
            StringTokenizer st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = INF;
            max = N * M;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                str = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (str.charAt(j) == '*') {
                        visited[i][j] = true;
                        max--;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j]) continue;
                    visited[i][j] = true;
                    sol(i, j, 1, 0);
                    visited[i][j] = false;
                }
            }
            sb.append("Case ").append(T).append(": ").append(answer == INF ? -1 : answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void sol(int y, int x, int count, int move) {
        if (count == max) {
            answer = move;
            return;
        }
        if (answer <= move) return;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
            while (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx]) {
                visited[ny][nx] = true;
                ny += dy[i];
                nx += dx[i];
                count++;
            }
            ny -= dy[i];
            nx -= dx[i];
            sol(ny, nx, count, move + 1);
            for (; !(ny == y && nx == x); ny -= dy[i], nx -= dx[i]) {
                visited[ny][nx] = false;
                count--;
            }
        }
    }
}
