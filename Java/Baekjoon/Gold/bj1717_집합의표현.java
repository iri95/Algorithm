package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1717_집합의표현 {
    static int[] root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        root = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                union(b, c);
                continue;
            }
            if (b == c) {
                sb.append("YES").append("\n");
                continue;
            }
            if (find(b) != find(c)) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }
        System.out.println(sb);

    }

    static int find(int k) {
        if (root[k] == k) return k;
        else return find(root[k]);
    }

    static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if (ap < bp) root[bp] = ap;
        else root[ap] = bp;
    }
}
