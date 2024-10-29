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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nArr = new int[n + 1];
        mArr = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) nArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) mArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        if (m < n) {
            int temp = m;
            m = n;
            n = temp;

            int[] tempArr = mArr;
            mArr = nArr;
            nArr = tempArr;
        }

        dp = new int[n + 1][m + 1]; // 이 커플이 이어질 경우의 최솟값.
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= m; j++) {
                dp[i][j] = dp[i - 1][j - 1] + Math.abs(nArr[i] - mArr[j]);
                if (i < j) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[n][m]);
    }
}
