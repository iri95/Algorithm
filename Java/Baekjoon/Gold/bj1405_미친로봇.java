package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1405_미친로봇 {
    static int N;
    static double e, w, s, north, sum = 0;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][] visit = new boolean[30][30];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        e = Double.parseDouble(st.nextToken()) / 100;
        w = Double.parseDouble(st.nextToken()) / 100;
        s = Double.parseDouble(st.nextToken()) / 100;
        north = Double.parseDouble(st.nextToken()) / 100;
        visit[15][15] = true;
        dfs(0, 1, 15, 15);
        System.out.println(sum);
    }

    static void dfs(int n, double count, int y, int x) {
        if (n == N) {
            sum += count;
            return;
        }
        // e
        int ny = y + dy[0];
        int nx = x + dx[0];
        if (!visit[ny][nx]) {
            visit[ny][nx] = true;
            dfs(n + 1, count * e, y + dy[0], x + dx[0]);
            visit[ny][nx] = false;
        }
        // w
        ny = y + dy[1];
        nx = x + dx[1];
        if (!visit[ny][nx]) {
            visit[ny][nx] = true;
            dfs(n + 1, count * w, y + dy[1], x + dx[1]);
            visit[ny][nx] = false;
        }

        // s
        ny = y + dy[2];
        nx = x + dx[2];
        if (!visit[ny][nx]) {
            visit[ny][nx] = true;
            dfs(n + 1, count * s, y + dy[2], x + dx[2]);
            visit[ny][nx] = false;
        }

        // n
        ny = y + dy[3];
        nx = x + dx[3];
        if (!visit[ny][nx]) {
            visit[ny][nx] = true;
            dfs(n + 1, count * north, y + dy[3], x + dx[3]);
            visit[ny][nx] = false;
        }

    }
}
