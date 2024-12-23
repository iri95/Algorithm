package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj16565_N포커 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 10_007;
        int[][] comb = new int[53][53];
        for (int i = 0; i <= 52; i++) comb[i][0] = 1;
        for (int i = 1; i <= 52; i++)
            for (int j = 1; j <= 52; j++)
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % mod;

        int ans = 0;
        for (int i = 1; i <= 13 && N - 4 * i >= 0; i++) {
            if (i % 2 == 1) ans = (ans + comb[52 - 4 * i][N - 4 * i] * comb[13][i]) % mod;
            else ans = (ans - (comb[52 - 4 * i][N - 4 * i] * comb[13][i]) % mod + mod) % mod;
        }

        System.out.println(ans);
    }
}
