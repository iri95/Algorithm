package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2560_짚신벌레 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1]; // 해당하는 날짜에 태어난 개체의 수.
        dp[0] = 1;
        int sum = 0; // 개체 생성 가능한 개체의 개수
        int ans = d > N ? 1 : 0;
        for (int i = 1; i <= N; i++) {
            if (i - a >= 0) sum += dp[i - a]; // 새로 생성할 수 있는 개체
            if (i - b >= 0) sum -= dp[i - b]; // 새로 생성하지 못하는 개체
            dp[i] = sum % 1000; // 새로 생성된 개체
            if (i + d > N) ans += dp[i];
        }
        ans %= 1000;
        System.out.println(ans);
    }
}
