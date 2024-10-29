package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1727_커플만들기 {
    static int m, n, INF = 1_000_000_001;
    static int[] mArr, nArr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        mArr = new int[m];
        nArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) mArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nArr[i] = Integer.parseInt(st.nextToken());

        if (m > n) {
            int temp = m;
            m = n;
            n = temp;

            int[] tempArr = mArr;
            mArr = nArr;
            nArr = tempArr;
        }
        Arrays.sort(mArr);
        Arrays.sort(nArr);

        dp = new int[m][n]; // 이 커플이 이어질 경우의 최솟값.
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], INF);
        int result = INF;
        for (int i = 0; i <= n - m; i++)
            result = Math.min(result, dfs(0, i));

        System.out.println(result);
    }

    private static int dfs(int a, int b){
        if (dp[a][b] != INF) return dp[a][b];
        if (a == m - 1) return dp[a][b] = Math.abs(mArr[a] - nArr[b]);

        for (int i = b + 1; i <= n - m + a + 1; i++)
            dp[a][b] = Math.min(dp[a][b], dfs(a + 1, i));

        return dp[a][b] += Math.abs(mArr[a] - nArr[b]);
    }
}
