package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://m.blog.naver.com/occidere/221120907901
// 이걸 모든 경우를 dp를 사용해서 할 생각을 못함..
public class bj2666_벽장문의이동 {
    static int N, M;
    static int[] list;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int empty1 = Integer.parseInt(st.nextToken());
        int empty2 = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        list = new int[M + 1];
        for (int i = 1; i <= M; i++) list[i] = Integer.parseInt(br.readLine());
        dp = new int[M + 1][N + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(move(1, empty1, empty2));
    }

    public static int move(int step, int x, int y) {
        if (step > M) return 0;
        if (dp[step][x][y] != -1) return dp[step][x][y];
        return dp[step][x][y] = Math.min(
                Math.abs(y - list[step]) + move(step + 1, x, list[step]),
                Math.abs(x - list[step]) + move(step + 1, y, list[step]));
    }
}
