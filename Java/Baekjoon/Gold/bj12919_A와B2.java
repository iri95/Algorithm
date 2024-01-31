package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://superohinsung.tistory.com/67
public class bj12919_A와B2 {
    static boolean result;
    static StringBuilder sb1, sb2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb1 = new StringBuilder(br.readLine());
        sb2 = new StringBuilder(br.readLine());

        dfs(sb2);
        if (result) System.out.println(1);
        else System.out.println(0);
    }

    static void dfs(StringBuilder sb) {
        if (result) return;
        if (sb1.length() == sb.length()) {
            if (sb1.compareTo(sb) == 0) result = true;
            return;
        }
        if (sb.charAt(0) == 'B') {
            StringBuilder str = new StringBuilder(sb.substring(1));
            str.reverse();
            dfs(str);
        }

        if (sb.charAt(sb.length() - 1) == 'A') {
            StringBuilder str = new StringBuilder(sb.substring(0, sb.length() - 1));
            dfs(str);
        }
    }
}
