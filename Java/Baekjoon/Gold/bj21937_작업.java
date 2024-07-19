package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj21937_작업 {
    static int N, M, cnt = 0;
    static boolean[] visited;
    static List<Integer>[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) parents[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parents[b].add(a);
        }
        dfs(Integer.parseInt(br.readLine()));
        System.out.println(cnt);
    }
    private static void dfs(int n){
        for (int i : parents[n]) {
            if (!visited[i]){
                visited[i] = true;
                cnt++;
                dfs(i);
            }
        }
    }
}
