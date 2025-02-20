package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj12843_복수전공 {
    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] lists;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        List<Integer> c = new ArrayList<>();
        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (st.nextToken().charAt(0) == 'c') c.add(num);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }

        int cnt = 0;
        for (int num : c) {
            visited = new boolean[n + 1];
            if (matching(num)) cnt++;
        }

        for (int i = 1; i <= n; i++)
            if (parent[i] == 0) cnt++;


        System.out.println(cnt);
    }
    private static boolean matching(int n){
        if (visited[n]) return false;
        visited[n] = true;
        for(int next : lists[n]){
            if (parent[next] == 0 || matching(parent[next])){
                parent[next] = n;
                parent[n] = next;
                return true;
            }
        }
        return false;
    }
}
