package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1990_소수인팰린드롬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Math.min(Integer.parseInt(st.nextToken()), 10_000_000);
        if (a % 2 == 0) a++;

        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i += 2) {
            if (i == 13) {
                i = 99;
                continue;
            } else if (i == 1001){
                i = 9999;
                continue;
            } else if (i == 100001) {
                i = 999999;
                continue;
            }

            if (isPell(String.valueOf(i)) && isPrime(i))
                sb.append(i).append("\n");
        }

        System.out.println(sb.append(-1));
    }

    private static boolean isPell(String str) {
        int len = str.length();

        for (int i = 0; i < len / 2; i++)
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;

        return true;
    }

    private static boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}