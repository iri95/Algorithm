package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11377_열혈강호3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int n = N + M + 3;
        int source = 0;
        int k = N + M + 1;
        int sink = N + M + 2;
        int[][] capacity = new int[n][n];
        capacity[source][k] = K;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t; j++) {
                int nxt = Integer.parseInt(st.nextToken());
                capacity[i][N + nxt] = 1;
            }
            capacity[source][i] = 1;
            capacity[k][i] = 1;
        }

        for (int i = 1; i <= M; i++)
            capacity[N + i][sink] = 1;

        int[][] flow = new int[n][n];
        int[] parents = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        int answer = 0;
        while(true){
            q.add(source);
            Arrays.fill(parents, -1);
            while (!q.isEmpty() && parents[sink] == -1) {
                int cur = q.poll();
                for (int i = 1; i < n; i++) {
                    if (capacity[cur][i] > flow[cur][i] && parents[i] == -1){
                        parents[i] = cur;
                        q.add(i);
                    }
                }
            }
            if (parents[sink] == -1) break;

            for (int i = sink; i != source ; i = parents[i]) {
                flow[parents[i]][i] += 1;
                flow[i][parents[i]] -= 1;
            }
            q.clear();
            answer++;
        }

        System.out.println(answer);
    }
}
