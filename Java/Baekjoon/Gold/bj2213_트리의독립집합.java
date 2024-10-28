package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2213_트리의독립집합 {
    static int N;
    static int[] cost;
    static int[][] dp; // 해당 정점 참석 여부, 가중치의 합
    static List<Integer>[] child;

    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cost = new int[N + 1];
        dp = new int[2][N + 1];
        child = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            child[i] = new ArrayList<>();
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            child[p].add(c);
            child[c].add(p);
        }
        dfs(1, 1, 0);
        dfs(0, 1, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(dp[0][1], dp[1][1])).append("\n");

        visited = new boolean[N + 1];
        getList(dp[0][1] > dp[1][1] ? 0 : 1, 1, 0);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++)  sb.append(list.get(i)).append(" ");
        System.out.println(sb);
    }

    private static int dfs(int v, int n, int p) {
        if (dp[v][n] != 0) return dp[v][n];
        boolean flag = true;
        int sum = v == 1 ? cost[n] : 0;
        for (int next : child[n]) {
            if (p == next) continue;
            flag = false;
            if (v == 0) sum += Math.max(dfs(1, next, n), dfs(0, next, n));
            else sum += dfs(0, next, n);
        }
        if (flag) {
            if (v == 0) return dp[v][n] = 0;
            else return dp[v][n] = cost[n];
        } else return dp[v][n] = sum;
    }

    private static void getList(int v, int n, int p){
        if (v == 1) {
            list.add(n);
            for (int next : child[n]) {
                if (next == p) continue;
                getList(0, next, n);
            }
        } else {
            for (int next : child[n]) {
                if (next == p) continue;
                if (dp[1][next] > dp[0][next]) {
                    getList(1, next, n);
                }else {
                    getList(0, next, n);
                }
            }
        }
    }
}
