package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3584_가장가까운공통조상 {
    static int[] parent;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
            }
            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());
            findParent(target1, target2);
        }
        System.out.println(sb);
    }

    static void findParent(int a, int b) {
        while (a > 0) {
            visited[a] = true;
            a = parent[a];
        }

        while (b != 0 && !visited[b]) {
            b = parent[b];
        }

        sb.append(b).append("\n");
    }
}
