package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 연료가 딱 나눠떨어지는게 아닐 경우도 생각해야지...
// 이전 주유소의 가격이 더 적을 떄 다음 주유소를 만났을 때도 남아있어야 함...
public class bj16399_드라이브 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        long[] dp = new long[D + 1];
        int[] remain = new int[D + 1];
        long maxValue = Long.MAX_VALUE;
        Arrays.fill(dp, maxValue);
        for (int i = 0; i <= C / E; i++) {
            dp[i] = 0;
            remain[i] = C - i * E;
        }
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N + 2];
        list[N] = 100001;
        int listSum = 0;
        int[] listValue = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            listSum += Integer.parseInt(st.nextToken());
            list[i] = listSum;
            listValue[i] = Integer.parseInt(st2.nextToken());
        }
        int listIndex = 1;
        for (int i = 0; i <= D; i++) {
            if (dp[i] == maxValue) break;
            if (list[listIndex] == i) {
                for (int j = i + 1; j <= i + C / E && j <= D; j++) {
                    if (dp[j] > dp[j - 1] + (long) listValue[listIndex] * E) { // max 값 or 이전 주유소 값보다 작다
                        if (remain[j - 1] < E) { // Max 값이라는 뜻, 이전 주유소가 더 쌀 수도? 더 싸다면 k, remain[j-1] 아니면 E
                            int k = E - remain[j - 1];
                            dp[j] = Math.min(dp[j - 1] + (dp[j - 1] - dp[j - 2]) / E * remain[j - 1] + (long) listValue[listIndex] * k, dp[j - 1] + (long) listValue[listIndex] * E);
                        } else { // Max 값 아님 이전 주유소가 더 비싸다는 뜻
                            dp[j] = dp[j - 1] + (long) listValue[listIndex] * E;
                        }
                        remain[j] = C - (i - list[listIndex]) * E;
                    }

                }
                listIndex++;
            }
        }
        if (dp[D] == maxValue) {
            System.out.println(-1);
        } else {
            System.out.println(dp[D]);
        }
    }
}
