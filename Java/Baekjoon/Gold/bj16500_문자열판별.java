package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class bj16500_문자열판별 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(br.readLine());

        int[] dp = new int[str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            if (set.contains(str.substring(i))) {
                dp[i] = 1;
                continue;
            }
            for (int j = i + 1; j < str.length(); j++) {
                if (dp[j] == 1 && set.contains(str.substring(i, j))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        System.out.println(dp[0]);
    }
}
