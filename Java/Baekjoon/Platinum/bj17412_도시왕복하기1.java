package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17412_도시왕복하기1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[][] capacity = new int[N + 1][N + 1];
        int[][] flow = new int[N + 1][N + 1];
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            capacity[s][e] = 1;
        }
        int ans = 0;
        int[] parents = new int[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        while(true){
            q.add(1);
            Arrays.fill(parents, -1);
            while (!q.isEmpty() && parents[2] == -1) {
                int cur = q.poll();
                for (int i = 1; i <= N; i++) {
                    if (capacity[cur][i] - flow[cur][i] > 0 && parents[i] == -1){
                        q.add(i);
                        parents[i] = cur;
                    }
                }
            }

            if (parents[2] == -1) break;
            for (int i = 2; i != 1; i = parents[i]) {
                flow[parents[i]][i] = 1;
                flow[i][parents[i]] = -1;
            }
            ans++;
            q.clear();
        }
        System.out.println(ans);
    }
}
