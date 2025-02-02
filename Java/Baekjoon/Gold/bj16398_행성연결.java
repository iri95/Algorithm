package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16398_행성연결 {
    private static class Flow implements Comparable<Flow> {
        int no;
        long cost;

        Flow(int no, int cost) {
            this.no = no;
            this.cost = cost;
        }

        public int compareTo(Flow f) {
            if (this.cost < f.cost) return -1;
            else if (this.cost > f.cost) return 1;
            else return 0;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Flow>[] lists = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) lists[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i == j) continue;
                lists[i].add(new Flow(j, cost));
            }
        }

        Queue<Flow> pq = new PriorityQueue<>();
        pq.add(new Flow(1, 0));
        boolean[] visited = new boolean[N + 1];
        long answer = 0;
        while (!pq.isEmpty()) {
            Flow cur = pq.poll();
            if (visited[cur.no]) continue;
            visited[cur.no] = true;
            answer += cur.cost;
            for (Flow next : lists[cur.no]) {
                if (visited[next.no]) continue;
                pq.add(next);
            }
        }
        System.out.println(answer);
    }
}
