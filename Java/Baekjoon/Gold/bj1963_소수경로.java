package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1963_소수경로 {
    static boolean[] arr = new boolean[10000];
    static List<Integer>[] list = new ArrayList[10000];
    public static void main(String[] args) throws Exception {
        init();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == b) {
                sb.append(0).append("\n");
                continue;
            }
            boolean[] visited = new boolean[10000];
            Queue<Integer> q = new ArrayDeque<>();
            q.add(a);
            visited[a] = true;
            int count = 0;
            w: while (!q.isEmpty()) {
                int size = q.size();
                count++;
                for (int s = 0; s < size; s++) {
                    int now = q.poll();
                    for (int next: list[now]) {
                        if (visited[next]) continue;
                        visited[next] = true;
                        q.add(next);
                        if (next == b) break w;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    private static void init(){
        for (int i = 2; i <= 100; i++)
            for (int j = i * 2; j < 10000; j += i)
                arr[j] = true;

        for (int i = 1000; i < 10000; i++) list[i] = new ArrayList<>();

        for (int i = 1000; i < 10000; i++) {
            if (arr[i]) continue;
            int k1 = i - (i % 10);
            int k10 = i - (i/10 % 10) * 10;
            int k100 = i - (i/100 % 10) * 100;
            int k1000 = i - (i/1000 % 10) * 1000;
            for (int j = 0; j <= 9; j++) {
                if (!arr[k1 + j] && k10 + j != i) list[i].add(k1 + j);
                if (!arr[k10 + j * 10] && k10 + j * 10 != i) list[i].add(k10 + j * 10);
                if (!arr[k100 + j * 100] && k100 + j * 100 != i) list[i].add(k100 + j * 100);
                if (j != 0 && !arr[k1000 + j * 1000] && k1000 + j * 1000 != i) list[i].add(k1000 + j * 1000);
            }
        }
    }
}
