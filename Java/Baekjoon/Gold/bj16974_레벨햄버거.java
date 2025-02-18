package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16974_레벨햄버거 {
    static long[] patti, burger;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        patti = new long[N + 1];
        burger = new long[N + 1];
        burger[0] = patti[0] = 1;
        for (int i = 1; i <= N; i++) {
            patti[i] = patti[i - 1] * 2 + 1;
            burger[i] = 3 + burger[i - 1] * 2;
        }
        System.out.println(sol(N, X));

    }

    private static long sol(int n, long x) {
        if (n == 0) return 1;
        if (x <= n) return 0;
        if (burger[n] / 2 + 1 == x) return patti[n - 1] + 1;
        else if (burger[n] / 2 + 1 > x) return sol(n - 1, x - 1);
        else return sol(n - 1, x - burger[n - 1] - 2) + patti[n - 1] + 1;
    }

}
