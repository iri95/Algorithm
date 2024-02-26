import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16947_서울지하철2호선 {
    static class Node {
        int index;
        List<Integer> list = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }
    }

    static int N;
    static boolean[] visit;
    static Node[] nodes;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        result = new int[N + 1];
        Arrays.fill(result, 3001);
        for (int i = 0; i <= N; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].list.add(b);
            nodes[b].list.add(a);
        }
        for (int i = 1; i <= N; i++) {
            if (result[i] == 0) continue;
            visit = new boolean[N + 1];
            cycle(i, i, -1);
        }
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (result[i] == 0) {
                dfs(i, 0);
                break;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    static boolean cycle(int start, int index, int parent) {
        visit[index] = true;
        Node node = nodes[index];
        for (int n : node.list) {
            if (visit[n] && n == parent) continue;
            if (n == start) {
                result[start] = 0;
                return true;
            }
            if (visit[n]) continue;
            if (cycle(start, n, index)) {
                result[n] = 0;
                return true;
            }
        }
        return false;
    }

    static void dfs(int index, int count) {
        visit[index] = true;
        for (int k: nodes[index].list) {
            if (visit[k]) continue;
            if (result[k] == 0) {
                dfs(k, count);
            } else {
                result[k] = count + 1;
                dfs(k, count + 1);
            }
        }
    }
}
