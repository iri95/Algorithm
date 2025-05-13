package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj4354_문자열제곱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] table;
        int idx, aLen, n;
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            n = str.length();
            table = new int[n];
            idx = 0;

            for (int i = 1; i < n; i++) {
                if (idx > 0 && str.charAt(i) != str.charAt(idx))
                    idx = 0;

                if (str.charAt(i) == str.charAt(idx))
                    table[i] = ++idx;
            }

            aLen = n - table[n - 1];
            if (n % aLen != 0) sb.append(1).append("\n");
            else sb.append(n / aLen).append("\n");
        }

        System.out.println(sb);
    }
}
