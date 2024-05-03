package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj11657_타임머신 {
    static class Vertex{
        int start;
        int end;
        int cost;
        public Vertex(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Vertex[] vertices = new Vertex[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            vertices[i] = new Vertex(s, e, c);
        }
        int INF = Integer.MAX_VALUE;
        long[] distance = new long[N + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                Vertex vertex = vertices[j];
                if(distance[vertex.start] != INF && distance[vertex.start] + vertex.cost < distance[vertex.end]){
                     distance[vertex.end] = distance[vertex.start] + vertex.cost;
                     if (i == N) {
                         System.out.println(-1);
                         return;
                     }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (distance[i] == INF) sb.append(-1).append("\n");
            else sb.append(distance[i]).append("\n");
        }
        System.out.println(sb);


    }
}
