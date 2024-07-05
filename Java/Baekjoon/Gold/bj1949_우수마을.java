package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1949_우수마을 {
    static int N;
    static int[] person;
    static List<Integer>[] nodes;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        person = new int[N + 1];
        nodes = new ArrayList[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
        dp = new int[N + 1][2]; // 0 : 우수마을
        System.out.println(Math.max(dfs(1, 0, 0), dfs(1, 1, 0)));
    }

    private static int dfs(int now, int state, int parent) {
        if (dp[now][state] != 0) return dp[now][state];
        if (state == 0) {
            for (int next : nodes[now])
                if (next != parent)
                    dp[now][0] += dfs(next, 1, now);
            dp[now][0] += person[now];
        } else
            for (int next : nodes[now])
                if (next != parent)
                    dp[now][1] += Math.max(dfs(next, 0, now), dfs(next, 1, now));
        return dp[now][state];
    }
}
