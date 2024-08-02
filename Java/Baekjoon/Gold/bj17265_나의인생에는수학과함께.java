package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj17265_나의인생에는수학과함께 {
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static char[][] map;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().replace(" ", "").toCharArray();
        char[] chars = new char[2 * N - 1];
        chars[0] = map[0][0];
        dfs(0, 0, chars);
        System.out.println(max + " " + min);
    }

    private static void dfs(int y, int x, char[] chars) {
        if (y == N - 1 && x == N - 1) {
            int result = chars[0] - '0';
            for (int i = 1; i < 2 * N - 1; i += 2)
                result = math(result, chars[i], chars[i + 1] - '0');

            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            chars[ny + nx] = map[ny][nx];
            dfs(ny, nx, chars);
        }
    }

    private static int math(int x, char ex, int y) {
        if (ex == '+') return x + y;
        else if (ex == '*') return x * y;
        else return x - y;
    }

}
