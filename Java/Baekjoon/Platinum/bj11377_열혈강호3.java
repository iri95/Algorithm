package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj11377_열혈강호3 {
    static int N, M, K;
    static int[] work;
    static boolean[] visited;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];
        work = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t; j++) {
                int nxt = Integer.parseInt(st.nextToken());
                lists[i].add(nxt);
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[M + 1];
            if (dfs(i)) ans++;
        }
        for (int i = 1; i <= N; i++) {
            visited = new boolean[M + 1];
            if (dfs(i)){
                ans++;
                K--;
            }
            if (K == 0) break;
        }

        System.out.println(ans);
    }
    private static boolean dfs(int num) {
        for (int w : lists[num]) {
            if(visited[w]) continue;
            visited[w] = true;
            if(work[w] == 0 || dfs(work[w])){
                work[w] = num;
                return true;
            }
        }
        return false;
    }
}
