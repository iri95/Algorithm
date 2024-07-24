package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2637_장난감조립 {
    private static class Node {
        int num, cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] mid = new boolean[N + 1];
        int[] count = new int[N + 1];
        count[N] = 1;
        int[] degree = new int[N + 1];
        List<Node>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            degree[b]++;
            mid[a] = true;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        while (!q.isEmpty()) {
            int num = q.poll();
            for (Node next : list[num]) {
                count[next.num] += count[num] * next.cnt;
                degree[next.num]--;
                if (degree[next.num] == 0) q.add(next.num);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++)
            if (!mid[i]) sb.append(i).append(" ").append(count[i]).append("\n");

        System.out.println(sb);
    }
}