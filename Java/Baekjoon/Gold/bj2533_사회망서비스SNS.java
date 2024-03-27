package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://castlehi.tistory.com/entry/%EB%B0%B1%EC%A4%80-Java-2533%EB%B2%88-%EC%82%AC%ED%9A%8C%EB%A7%9D-%EC%84%9C%EB%B9%84%EC%8A%A4SNS
public class bj2533_사회망서비스SNS {
    static int N;
    static List<Integer>[] list;
    static boolean[] visit;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list[parent].add(child);
            list[child].add(parent);
        }
        dp = new int[N + 1][2];
        visit = new boolean[N + 1];
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    static void dfs(int index){
        visit[index] = true;
        dp[index][0] = 1;
        dp[index][1] = 0;
        for (int idx : list[index]) {
            if (!visit[idx]) {
                dfs(idx);
                dp[index][0] += Math.min(dp[idx][0], dp[idx][1]);
                dp[index][1] += dp[idx][0];
            }
        }
    }
}
