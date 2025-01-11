package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1867_돌멩이제거 {
    static int[] matching;
    static boolean[] visited;
    static List<Integer>[] edge;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        matching = new int[N + 1];
        edge = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) edge[i] = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a].add(b);
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            if(bipartite(i)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean bipartite(int n){
        for (int b: edge[n]) {
            if (visited[b]) continue;
            visited[b] = true;
            if (matching[b] == 0 || bipartite(matching[b])){
                matching[b] = n;
                return true;
            }
        }
        return false;
    }
}
