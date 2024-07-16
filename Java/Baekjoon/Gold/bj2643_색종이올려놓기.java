package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2643_색종이올려놓기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                list[i][0] = a;
                list[i][1] = b;
            } else {
                list[i][0] = b;
                list[i][1] = a;
            }
        }
        Arrays.sort(list, (o1, o2) -> {
            if(o2[0] == o1[0]) return o2[1] - o1[1];
            return o2[0] - o1[0];
        });
        int[] dp = new int[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--)
                if (list[i][1] <= list[j][1]) max = Math.max(dp[j], max);
            dp[i] = max + 1;
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }
}
