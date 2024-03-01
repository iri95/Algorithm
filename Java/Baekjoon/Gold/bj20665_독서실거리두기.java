package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
총 720 시간 0900 ~ 2100을 다 숫자로 변환
 */
public class bj20665_독서실거리두기 {
    static class Node implements Comparable<Node> {
        int number;
        int count;
        int endTime;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
            this.endTime = 721;
        }

        public int compareTo(Node o) {
            if (o.count == this.count) return this.number - o.number;
            return o.count - this.count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new Node(i, N);
        }
        int[][] list = new int[T][3];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            list[i][0] = (Integer.parseInt(start.substring(0, 2)) - 9) * 60 + Integer.parseInt(start.substring(2));
            list[i][1] = (Integer.parseInt(end.substring(0, 2)) - 9) * 60 + Integer.parseInt(end.substring(2));
            list[i][2] = list[i][1] - list[i][0];
        }
        Arrays.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[2] - o2[2];
            return o1[0] - o2[0];
        });
        int max = 721;
        int result = 720;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < T; i++) {
            for (int j = 1; j <= N; j++) {
                if (list[i][0] >= nodes[j].endTime) {
                    nodes[j].endTime = max;
                    set.remove(j);
                    nodes[j].count = N;
                }
            }
            for (int j = 1; j <= N; j++) {
                if (!set.contains(j)) nodes[j].count = N;
            }
            for (int zero : set) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(zero);
                boolean[] visit = new boolean[N + 1];
                visit[zero] = true;
                int count = 0;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    count++;
                    while (size-- > 0) {
                        int k = queue.poll();
                        if (k - 1 > 0 && !visit[k - 1] && nodes[k - 1].count > count) {
                            nodes[k - 1].count = Math.min(nodes[k - 1].count, count);
                            visit[k - 1] = true;
                            queue.add(k - 1);
                        }
                        if (k + 1 <= N && !visit[k + 1] && nodes[k + 1].count > count) {
                            nodes[k + 1].count = Math.min(nodes[k + 1].count, count);
                            visit[k + 1] = true;
                            queue.add(k + 1);
                        }
                    }
                }
            }

            // target을 찾는다.
            int target = 1;
            for (int j = 2; j <= N; j++) {
                target = nodes[j].compareTo(nodes[target]) < 0 ? j : target;
            }

            // target이 원하는 좌석이라면 결과에서 빼기
            if (target == P) {
                result -= list[i][2];
            }
            // target 이용중 처리
            nodes[target].endTime = list[i][1];
            nodes[target].count = 0;
            set.add(target);
        }
        System.out.println(result);
    }
}
