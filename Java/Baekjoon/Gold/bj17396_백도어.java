package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj17396_백도어 {
    private static class Node implements Comparable<Node> {
        int num;
        long cost;

        private Node(int num, long cost) {
            this.num = num;
            this.cost = cost;
        }

        public int compareTo(Node next) {
            return (int) (this.cost - next.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node>[] lists = new ArrayList[N];
        for (int i = 0; i < N; i++) lists[i] = new ArrayList<>();

        long INF = Long.MAX_VALUE;
        long[] distance = new long[N];
        Arrays.fill(distance, INF);
        distance[0] = 0;

        boolean[] visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) visited[i] = st.nextToken().equals("1");

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (visited[a] || visited[b]) continue;
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        visited = new boolean[N];
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.num]) continue;
            visited[cur.num] = true;
            for (Node next : lists[cur.num]) {
                long dis = cur.cost + next.cost;
                if(!visited[next.num] && distance[next.num] > dis){
                    distance[next.num] = dis;
                    pq.add(new Node(next.num, dis));
                }
            }
        }
        System.out.println(distance[N - 1] == INF ? -1 : distance[N - 1]);
    }
}
