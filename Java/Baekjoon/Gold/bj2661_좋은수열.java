package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bj2661_좋은수열 {
    static int N;
    static StringBuilder sb;
    static Map<Integer, String> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        map = new HashMap<>();
        dfs(0);
        System.out.println(sb);
    }

    private static boolean dfs(int n) {
        for (int k = 1; k <= n / 2; k++)
            if (map.get(k).equals(sb.substring(n - k))) return false;

        if (n == N) return true;
        for (int j = 1; j <= 3; j++) {
            sb.append(j);
            for (int k = 1; k <= (n + 1) / 2; k++)
                map.put(k, sb.substring(n - (2 * k - 1), n - k + 1));

            if (!dfs(n + 1)) sb.deleteCharAt(sb.length() - 1);
            else return true;
        }
        return false;
    }
}
