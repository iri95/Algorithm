package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17352_여러분의다리가되어드리겠습니다 {
    static int N;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set(a, b);
        }
        for (int i = 2; i <= N; i++) {
            if (find(i) != 1) {
                System.out.println("1 " + i);
                return;
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    static void set(int x, int y){
        int xP = find(x);
        int yP = find(y);
        if (xP > yP) parent[xP] = yP;
        else parent[yP] = xP;
    }
}
