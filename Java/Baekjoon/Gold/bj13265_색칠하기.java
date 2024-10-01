package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj13265_색칠하기 {
    static int N;
    static int[] color;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N + 1];
            color = new int[N + 1];
            for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            boolean flag = true;
            for (int i = 1; i <= N; i++) {
                if (color[i] != 0) continue;
                if (!bfs(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) sb.append("possible").append("\n");
            else sb.append("impossible").append("\n");
        }
        System.out.println(sb);
    }

    static boolean bfs(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        color[s] = 1;
        int c = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            c *= -1;
            while (size-- > 0) {
                int now = q.poll();
                for (int next : list[now]) {
                    if (color[next] == 0) {
                        color[next] = c;
                        q.add(next);
                    } else if (color[next] != c) return false;
                }
            }
        }
        return true;
    }
}
