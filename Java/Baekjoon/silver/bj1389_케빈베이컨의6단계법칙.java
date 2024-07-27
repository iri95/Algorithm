package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1389_케빈베이컨의6단계법칙 {
    static int N;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int min = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 1; i <= N; i++) {
            int count = bfs(i);
            if (min > count) {
                min = count;
                num = i;
            }
        }
        System.out.println(num);
    }
    static int bfs(int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        boolean[] visited = new boolean[N + 1];
        visited[n] = true;
        int sum = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while (size-- > 0) {
                int num = q.poll();
                for (int k: list[num]) {
                    if (visited[k]) continue;
                    sum += cnt;
                    visited[k] = true;
                    q.add(k);
                }
            }
        }
        return sum;
    }
}
