package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://ilmiodiario.tistory.com/148
public class bj1967_트리의지름 {
    static int N, ans;

    static class Node {
        int num, meter;

        public Node(int num, int meter) {
            this.num = num;
            this.meter = meter;
        }
    }
    static ArrayList<Node>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N ; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int meter = Integer.parseInt(st.nextToken());
            list[y].add(new Node(x, meter));
            list[x].add(new Node(y, meter));
        }
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            visit[i] = true;
            dfs(i, 0);
        }
        System.out.println(ans);

    }

    static void dfs(int num, int diameter) {
        for (Node node : list[num]) {
            if (!visit[node.num]) {
                visit[node.num] = true;
                dfs(node.num, diameter + node.meter);
            }
        }
        ans = Math.max(ans, diameter);
    }
}
