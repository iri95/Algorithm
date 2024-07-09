package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2342_DanceDanceRevolution {
    static int N;
    static List<Integer> list;
    static int[][][] dp;
    static int[][] force = {{1, 2, 2, 2, 2}, // force[x][y] : x에서 y로 이동할 때 드는 힘
            {0, 1, 3, 4, 3},
            {0, 3, 1, 3, 4},
            {0, 4, 3, 1, 3},
            {0, 3, 4, 3, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());
            if (next == 0) break;
            list.add(next);
        }
        N = list.size();
        if (N == 0) {
            System.out.println(0);
            return;
        }
        dp = new int[N + 1][5][5]; // 수행횟수, 이동한 발(왼,오)일 때 든 힘
        System.out.println(dfs(0, 0, 0));
    }

    // 현재 왼발 위치, 현재 오른발 위치, 이동할 위치 index
    private static int dfs(int l, int r, int n) {
        if (n == N) return 0;
        int next = list.get(n);
        int left = dp[n + 1][next][r] == 0 ? dfs(next, r, n + 1) + force[l][next] : dp[n + 1][next][r] + force[l][next];
        int right = dp[n + 1][l][next] == 0 ? dfs(l, next, n + 1) + force[r][next] : dp[n + 1][l][next] + force[r][next];
        dp[n][l][r] = Math.min(left, right);
        return dp[n][l][r];
    }
}
