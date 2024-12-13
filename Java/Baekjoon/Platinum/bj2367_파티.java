package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2367_파티 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int ND = N + D + 2;
        int[][] capacity = new int[ND][ND];
        int source = 0, sink = N + D + 1;
        // source와 사람을 연결
        for (int i = 1; i <= N; i++) capacity[0][i] = K;

        // sink와 접시를 연결
        st = new StringTokenizer(br.readLine());
        for (int i = N + 1; i < N + D + 1; i++)
            capacity[i][sink] = Integer.parseInt(st.nextToken());

        // 사람과 접시를 연결
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int dish = Integer.parseInt(st.nextToken()) + N;
                capacity[i][dish] = 1;
            }
        }

        int[][] flow = new int[ND][ND];
        int[] parents = new int[ND];
        Queue<Integer> q = new ArrayDeque<>();
        int ans = 0;
        while (true) {
            q.add(0);
            Arrays.fill(parents, -1);
            while (!q.isEmpty() && parents[sink] == -1) {
                int p = q.poll();
                for (int i = 1; i < ND; i++) {
                    if (parents[i] == -1 && capacity[p][i] > flow[p][i]) {
                        parents[i] = p;
                        q.add(i);
                    }
                }
            }
            if (parents[sink] == -1) break;
            for (int i = sink; i != 0; i = parents[i]) {
                flow[parents[i]][i] += 1;
                flow[i][parents[i]] -= 1;
            }
            ans++;
            q.clear();
        }
        System.out.println(ans);
    }
}
