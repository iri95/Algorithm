import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1277_발전소설치 {
    static class Node {
        int y;
        int x;
        List<Integer> linked = new ArrayList<>();

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        double M = Double.parseDouble(br.readLine());
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].linked.add(b);
            nodes[b].linked.add(a);
        }
        double[] distance = new double[N + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);
        distance[1] = 0;
        Queue<double[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) return (int) (o1[1] - o2[1]);
            return (int) (o1[2] - o2[2]);
        }); // node 번호, 전선 갯수
        pq.add(new double[]{1, 0, 0});
        while (!pq.isEmpty()) {
            double[] p = pq.poll();
            Node node = nodes[(int) p[0]];
            int count = (int) p[1];
            // 연결 되어있는 node들을 먼저 distance에 반영
            for (int next : node.linked) {
                if (distance[next] > distance[(int) p[0]]) {
                    distance[next] = distance[(int) p[0]];
                    pq.add(new double[]{next, count, 0});
                }
            }
            // 연결 되어있지 않은 node들을 모두 거리 계산하고 제한 길이보다 길 경우는 제외
            if (count < W) {
                for (int i = 1; i <= N; i++) {
                    double length = Math.sqrt(Math.pow(node.y - nodes[i].y, 2) + Math.pow(node.x - nodes[i].x, 2));
                    if (distance[(int) p[0]] + length < distance[i]) {
                        distance[i] = distance[(int) p[0]] + length;
                        pq.add(new double[]{i, count + 1, length});
                    }
                }
            }
        }
        System.out.println((int)(distance[N] * 1000));

    }
}
