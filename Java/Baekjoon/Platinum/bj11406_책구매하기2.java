package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11406_책구매하기2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sink = N + M + 1;
        int[][] capacity = new int[sink + 1][sink + 1];
        int[][] flow = new int[sink + 1][sink + 1];

        // source에서 사람으로 가는 용량 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int fromSource = Integer.parseInt(st.nextToken());
            capacity[0][i] = fromSource;
        }

        // 서점에서 Sink로 가는 용량 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int toSink = Integer.parseInt(st.nextToken());
            capacity[N + i][sink] = toSink;
        }

        // 사람에서 서점으로 가는 용량 초기화
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int toStoreFromPerson = Integer.parseInt(st.nextToken());
                capacity[j][N + i] = toStoreFromPerson;
            }
        }

        int[] parent = new int[sink + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int answer = 0;
        while(true){
            Arrays.fill(parent, -1);
            q.add(0);
            while(!q.isEmpty() && parent[sink] == -1){
                int cur = q.poll();
                for (int i = 1; i <= sink; i++) {
                    if (capacity[cur][i] > flow[cur][i] && parent[i] == -1){
                        parent[i] = cur;
                        q.add(i);
                    }
                }
            }
            if (parent[sink] == -1) break;
            int min = 101;
            for (int i = sink; i != 0 ; i = parent[i])
                min = Math.min(min, capacity[parent[i]][i] - flow[parent[i]][i]);
            answer += min;

            for (int i = sink; i != 0 ; i = parent[i]){
                flow[parent[i]][i] += min;
                flow[i][parent[i]] -= min;
            }
            q.clear();
        }
        System.out.println(answer);
    }
}
