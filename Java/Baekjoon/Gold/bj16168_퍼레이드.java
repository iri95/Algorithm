package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class bj16168_퍼레이드 {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[] nodes = new int[V + 1];
        parent = new int[V + 1];
        for (int i = 0; i <= V; i++) parent[i] = i;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a]++;
            nodes[b]++;
            set(a, b);
        }
        int even = 0;
        for (int i = 1; i <= V; i++) {
            if (nodes[i] == 0 || findParent(i) != 1) {
                System.out.println("NO");
                return;
            }
            if (nodes[i] % 2 != 0) even++;
        }
        if (even > 2 || even == 1) System.out.println("NO");
        else System.out.println("YES");
    }

    private static int findParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void set(int x, int y) {
        int xP = findParent(x);
        int yP = findParent(y);
        if (xP == yP) return;
        if (xP > yP) parent[xP] = yP;
        else parent[yP] = parent[xP];
    }
}
