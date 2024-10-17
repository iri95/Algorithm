package lv3;

public class 보행자천국 {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] memo = new int[m][n][2];
        for (int i = 0; i < n; i++) {
            if (cityMap[0][i] == 1) break;
            memo[0][i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (cityMap[i][0] == 1) break;
            memo[i][0][1] = 1;
        }
        for (int y = 1; y < m; y++) {
            for (int x = 1; x < n; x++) {
                if (cityMap[y][x] == 1) continue;
                if (cityMap[y - 1][x] == 0) memo[y][x][1] += (memo[y - 1][x][0] + memo[y - 1][x][1]) % MOD;
                else if (cityMap[y - 1][x] == 2) memo[y][x][1] += memo[y - 1][x][1];

                if (cityMap[y][x - 1] == 0) memo[y][x][0] += (memo[y][x - 1][0] + memo[y][x - 1][1]) % MOD;
                else if (cityMap[y][x - 1] == 2) memo[y][x][0] += memo[y][x - 1][0];
            }
        }
        return (memo[m - 1][n - 1][0] + memo[m - 1][n - 1][1]) % MOD;
    }
}