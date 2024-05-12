package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj15681_트리와쿼리 {
    static int N, R, Q;
    static int[] child;
    static boolean[] visited;
    static List<Integer>[] linked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        child = new int[N + 1];
        visited = new boolean[N + 1];
        linked = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            linked[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            linked[a].add(b);
            linked[b].add(a);
        }
        countChild(R);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(child[q]).append("\n");
        }
        System.out.println(sb);
    }

    static void countChild(int current) {
        visited[current] = true;
        child[current] = 1;
        for (int next : linked[current]) {
            if (visited[next]) continue;
            countChild(next);
            child[current] += child[next];
        }
    }
}
