package Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/source/76240881
public class bj10217_KCMTravel {
    static class Node {
        int e;
        int c;
        int d;

        public Node(int e, int c, int d) {
            this.e = e;
            this.c = c;
            this.d = d;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, M, K;
    static int[][] dp;
    static List<Node>[] nodes;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];
        nodes = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes[u].add(new Node(v, c, d));
        }

        for (int i = 0; i <= N; i++) {
            nodes[i].sort(Comparator.comparingInt(o -> o.d));
        }

        queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0, 0});
        dp[1][0] = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int s = p[0];
            int c = p[1];
            int d = p[2];

            if (s == N || dp[s][c] < d) continue;

            for (Node node : nodes[s]) {
                int next = node.e;
                int nextCost = node.c + c;
                int nextDist = node.d + d;

                if (nextCost > M || dp[next][nextCost] <= nextDist) continue;

                for (int i = nextCost; i <= M; i++) {
                    if (dp[next][i] > nextDist) dp[next][i] = nextDist;
                    else break;
                }
                queue.add(new int[]{next, nextCost, nextDist});
            }
        }

        int answer = INF;
        for (int i = 0; i <= M; i++) answer = Math.min(answer, dp[N][i]);
        System.out.println((answer == INF) ? "Poor KCM" : answer);
    }
}

