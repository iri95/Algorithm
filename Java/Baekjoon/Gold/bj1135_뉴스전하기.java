package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1135_뉴스전하기 {
    static int[] dp;
    static List<Integer>[] child;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N]; // 아래에 모두 뉴스를 전하는 데 걸리는 시간을 저장.
        child = new ArrayList[N];
        for (int i = 0; i < N; i++) child[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i < N; i++)
            child[Integer.parseInt(st.nextToken())].add(i);

        System.out.println(dfs(0));
    }

    private static int dfs(int n) {
        if (child[n] == null || dp[n] != 0) return dp[n] = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int c : child[n]) {
            int d = dfs(c) + 1;
            while (true) {
                if (set.contains(d)) d++;
                else {
                    set.add(d);
                    break;
                }
            }
            max = Math.max(max, d);
        }
        return dp[n] = max;
    }
}
