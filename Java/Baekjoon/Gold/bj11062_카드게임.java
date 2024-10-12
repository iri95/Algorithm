package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11062_카드게임 {
    static int[] arr;
    static int[][] dp; // 근우가 카드를 고른 경우를 저장하는 배열. 근우 차례에는 최대값, 명우 차례에는 최솟값을 가짐.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N];
            dp = new int[N][N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            sb.append(memo(0, N - 1, true)).append("\n");
        }
        System.out.println(sb);
    }

    private static int memo(int s, int e, boolean flag) {
        if (s > e) return 0;
        if (dp[s][e] != 0) return dp[s][e];
        if (flag) {
            return dp[s][e] = Math.max(arr[s] + memo(s + 1, e, false), arr[e] + memo(s, e - 1, false));
        } else {
            return dp[s][e] = Math.min(memo(s + 1, e, true), memo(s, e - 1, true));
        }
    }
}
