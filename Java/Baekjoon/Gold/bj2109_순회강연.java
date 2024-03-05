package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2109_순회강연 {
    static class Node implements Comparable<Node> {
        int p;
        int d;

        public Node(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if (o.p == this.p) return this.d - o.d;
            return o.p - this.p;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Node> pq = new PriorityQueue<>();
        int x = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.add(new Node(p, d));
            x = Math.max(d, x);
        }
        int max = 0;
        boolean[] visit = new boolean[x + 1];
        // 높은 값을 받는 걸 먼저 하고 그 자리에 이미 있다면 그보다 작은 작리의 값과 비교해서 더 큰 값을 쓴다.
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visit[node.d]) {
                for (int i = node.d - 1; i > 0; i--) {
                    if (!visit[i]) {
                        visit[i] = true;
                        max += node.p;
                        break;
                    }
                }
            }else{
                visit[node.d] = true;
                max += node.p;
            }
        }

        System.out.println(max);
    }
}
