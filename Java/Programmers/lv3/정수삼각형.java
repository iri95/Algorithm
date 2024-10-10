package lv3;

public class 정수삼각형 {
    static int N;
    static int[][] dp;

    public int solution(int[][] triangle) {
        N = triangle.length;
        dp = new int[N][N];

        return dynamic(0, 0, triangle);
    }

    private static int dynamic(int y, int x, int[][] arr) {
        if (dp[y][x] != 0) return dp[y][x];
        if (y == N - 1) return dp[y][x] = arr[y][x];
        return dp[y][x] = arr[y][x] + Math.max(dynamic(y + 1, x, arr), dynamic(y + 1, x + 1, arr));
    }
}
