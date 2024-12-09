package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1298_노트북의주인을찾아서 {
    static int N, M;
    static boolean[] visited;
    static int[] note;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N + 1];
        note = new int[5001];
        for (int i = 1; i <= N; i++) lists[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[5001];
            if (dfs(i)) ans++;
        }

        System.out.println(ans);
    }
    private static boolean dfs(int num){
        for (int n : lists[num]) {
            if(visited[n]) continue;
            visited[n] = true;
            if (note[n] == 0 || dfs(note[n])){
                note[n] = num;
                return true;
            }
        }
        return false;
    }
}
