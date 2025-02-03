package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj10216_CountCircleGroups {
    private static class Top {
        int x, y, r;

        Top(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Top[] tops = new Top[N];
            parent = new int[N];
            for (int i = 0; i < N; i++) parent[i] = i;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                tops[i] = new Top(x, y, r);
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (Math.pow(tops[i].x - tops[j].x, 2) + Math.pow(tops[i].y - tops[j].y, 2) <= Math.pow(tops[i].r + tops[j].r, 2))
                        union(i, j);
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) set.add(find(i));
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);

        if (ap == bp) return;

        if (ap > bp) parent[ap] = bp;
        else parent[bp] = ap;
    }
}
