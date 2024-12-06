package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2188_축사배정 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        arr = new int[M + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            while (t-- > 0) list[i].add(Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[M + 1];
            if (dfs(i)) ans++;
        }
        System.out.println(ans);
    }

    private static boolean dfs(int cow) {
        for (int w : list[cow]) {
            if (visited[w]) continue;
            visited[w] = true;
            if (arr[w] == 0 || dfs(arr[w])) {
                arr[w] = cow;
                return true;
            }
        }
        return false;
    }
}
