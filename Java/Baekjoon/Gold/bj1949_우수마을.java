package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1949_우수마을 {
    static int N;
    static boolean[] visited;
    static List<Integer>[] nodes;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2]; // 0 : 우수마을
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dp[i][0] += Integer.parseInt(st.nextToken());
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    // https://www.acmicpc.net/source/64087956
    private static void dfs(int now) {
        visited[now] = true;
        for (int next : nodes[now]) {
            if (visited[next]) continue;
            dfs(next);
            int tmp = Math.max(dp[next][0], dp[next][1]);
            dp[now][1] += tmp;
            dp[now][0] += dp[next][1];

        }
    }
}
