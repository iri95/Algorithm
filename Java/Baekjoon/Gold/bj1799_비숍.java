package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1799_비숍 {
    static int N;
    static boolean[] right;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = st.nextToken().equals("0");
        }
        right = new boolean[2 * N - 1];
        System.out.println(recursion(0) + recursion(1));
    }

    private static int recursion(int x) {
        if (x >= 2 * N - 1) return 0;
        int y = 0;
        if (x > N - 1){
            y = x - N + 1;
            x = N - 1;
        }
        int max = -1;
        while (x >= 0 && y < N) {
            if (!map[x][y] && !right[N - 1 - (x - y)]) {
                right[N - 1 - (x - y)] = true;
                max = Math.max(max, recursion(x + y + 2) + 1);
                right[N - 1 - (x - y)] = false;
            }
            x--; y++;
        }
        return max < 0 ? recursion(x + y + 2) : max;
    }
}
