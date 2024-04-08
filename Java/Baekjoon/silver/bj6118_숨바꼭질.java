package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj6118_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> pq = new ArrayDeque<>();
        List<Integer>[] nodes = new ArrayList[N + 1];
        boolean[] visit = new boolean[N + 1];
        pq.add(1);
        visit[1] = true;
        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
        int num = 0;
        int distance = -1;
        int count = 0;

        while (!pq.isEmpty()) {
            int size = pq.size();
            distance++;
            num = 20_001;
            count = size;
            while (size-- > 0) {
                int point = pq.poll();
                num = Math.min(point, num);
                for (int node: nodes[point]) {
                    if (visit[node]) continue;
                    visit[node] = true;
                    pq.add(node);
                }
            }
        }
        System.out.println(num + " " + distance + " " + count);

    }
}
