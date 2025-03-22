package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1033_칵테일 {
    static int N;
    static int[] value;
    static boolean[] visited;
    static List<Integer>[] link;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        value = new int[N];
        Arrays.fill(value, 1);
        link = new ArrayList[N];
        for (int i = 0; i < N; i++) link[i] = new ArrayList<>();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int gcd = GCD(p, q);
            p /= gcd;
            q /= gcd;
            list.add(new int[]{a, b, p, q});
            link[a].add(b);
            link[b].add(a);
        }

        for (int i = 0; i < N - 1; i++) {
            int[] arr = list.get(i);
            visited = new boolean[N];
            visited[arr[0]] = visited[arr[1]] = true;
            bfs(arr[0], arr[2]);
            bfs(arr[1], arr[3]);
        }

        int gcd = value[0];
        for (int i = 1; i < N; i++)
            gcd = GCD(value[i], gcd);

        for (int i = 0; i < N; i++)
            value[i] /= gcd;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(value[i]).append(" ");

        System.out.println(sb);
    }

    private static void bfs(int start, int v) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            value[cur] *= v;
            for (int next : link[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }
    }

    private static int GCD(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
