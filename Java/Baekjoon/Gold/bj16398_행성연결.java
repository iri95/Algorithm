package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
완전 그래프(밀집 그래프)에서는 간선의 수가 매우 많기 때문에, 우선순위 큐를 사용하는 방식은 각 간선마다 O(logN)의 추가 오버헤드가 발생한다.
반면, 인접 행렬을 사용한 첫 번째 방식은 정점의 수에 대해 매번 선형 탐색(O(N))만 수행하므로 전체 O(N2)로 처리할 수 있다.
따라서, 문제에서 다루는 그래프가 완전 그래프일 때는 이론적으로는 O(N2)인 첫 번째 코드가 O(N2logN)인 두 번째 코드보다 실행 속도가 빠르다.
 */
public class bj16398_행성연결 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        long[] min = new long[N];
        Arrays.fill(min, Long.MAX_VALUE);
        min[0] = 0;
        boolean[] visited = new boolean[N];
        long answer = 0;

        for (int i = 0; i < N; i++) {
            int minNode = 0;
            long minCost = Long.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && min[j] < minCost) {
                    minNode = j;
                    minCost = min[j];
                }
            }

            visited[minNode] = true;
            answer += min[minNode];

            for (int j = 0; j < N; j++) {
                if (!visited[j] && map[minNode][j] != 0 && min[j] > map[minNode][j])
                    min[j] = map[minNode][j];
            }
        }
        System.out.println(answer);
    }
}
/* Kruskal
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Flow implements Comparable<Flow> {
        int s, e, cost;

        Flow(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        public int compareTo(Flow f) {
            return this.cost - f.cost;
        }

    }

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) parent[i] = i;
        Queue<Flow> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i >= j) continue;
                pq.add(new Flow(i, j, cost));
            }
        }
        long answer = 0;
        while (!pq.isEmpty()) {
            Flow f = pq.poll();
            if (union(f.s, f.e))
                answer += f.cost;
        }
        System.out.println(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp == yp) return false;

        if (xp < yp) parent[yp] = xp;
        else parent[xp] = yp;
        return true;
    }
}
 */

/* Prim + Priority Queue
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
 */