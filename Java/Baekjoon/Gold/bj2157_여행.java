package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2157_여행 {
    static class Node {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Node>[] nodes = new ArrayList[N + 1];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        dp[1][1] = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (s > e) continue;
            nodes[s].add(new Node(e, c));
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (size-- > 0) {
                int now = q.poll();
                for (Node next : nodes[now]) {
                    if (dp[next.num][cnt + 1] < dp[now][cnt] + next.cost) {
                        dp[next.num][cnt + 1] = dp[now][cnt] + next.cost;
                        if (cnt + 1 < M) q.add(next.num);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 2; i <= M; i++) {
            ans = Math.max(ans, dp[N][i]);
        }
        System.out.println(ans);
    }
}
