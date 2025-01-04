package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1948_임계경로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] count = new int[N + 1];
        List<int[]>[] child = new ArrayList[N + 1];
        List<int[]>[] parent = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            child[i] = new ArrayList<>();
            parent[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            child[s].add(new int[]{d, c});
            parent[d].add(new int[]{s, c});
            count[d]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] maxCost = new int[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : child[cur]) {
                count[next[0]]--;
                maxCost[next[0]] = Math.max(maxCost[next[0]], maxCost[cur] + next[1]);
                if (count[next[0]] == 0) q.add(next[0]);
            }
        }

        int answerCount = 0;
        boolean[] visited = new boolean[N + 1];
        q.add(end);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : parent[cur]) {
                if (maxCost[cur] - next[1] == maxCost[next[0]]) {
                    answerCount++;
                    if (!visited[next[0]]) {
                        visited[next[0]] = true;
                        q.add(next[0]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxCost[end]).append("\n").append(answerCount);
        System.out.println(sb);
    }
}
