package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1799_비숍 {
    static int N;
    static int[][] count;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        count = new int[2 * N - 1][(int) Math.pow(2, 2 * N)];
        for (int i = 0; i < 2 * N - 1; i++) {
            Arrays.fill(count[i], -1);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = st.nextToken().equals("0");
        }
        System.out.println(recursion(0, 0));
    }

    private static int recursion(int x, int visited) {
        if (x == 2 * N - 1) return 0;
        if (count[x][visited] >= 0) return count[x][visited];
        int y = Math.max(x - N + 1, 0);
        x = Math.min(x, N - 1);
        int max = -1;
        while (x >= 0 && y < N) {
            int visit = visited | 1 << (N - 1 - (x - y));
            if (!map[x][y] && (visited & 1 << (N - 1 - (x - y))) == 0) {
                if (count[x + y][visit] >= 0) max = Math.max(max, count[x + y][visit]);
                else max = Math.max(max, recursion(x + y + 1, visit) + 1);
            }
            x--;
            y++;
        }
        if (max < 0) return count[x + y][visited] = recursion(x + y + 1, visited);
        else return count[x + y][visited] = max;
    }
}
