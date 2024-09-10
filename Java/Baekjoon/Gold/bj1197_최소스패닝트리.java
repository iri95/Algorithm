package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1197_최소스패닝트리 {
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        for (int i = 0; i <= V; i++) parents[i] = i;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b, c});
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            if (union(p[0], p[1])) ans += p[2];
        }
        System.out.println(ans);
    }

    private static int find(int n) {
        if (n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }

    private static boolean union(int x, int y){
        int p1 = find(x);
        int p2 = find(y);
        if (p1 == p2) return false;

        if (p1 < p2) parents[p2] = p1;
        else parents[p1] = p2;
        return true;
    }

}
