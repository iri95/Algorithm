package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16964_DFS스페셜저지 {
    static int N, index = 1;
    static int[] arr;
    static Set<Integer>[] sets;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sets = new HashSet[N + 1];
        for (int i = 0; i <= N; i++) sets[i] = new HashSet<>();
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sets[a].add(b);
            sets[b].add(a);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        dfs(1);
        if (index == N) System.out.println(1);
        else System.out.println(0);
    }

    private static void dfs(int n) {
        while(index < N){
            if (!sets[n].contains(arr[index])) return;
            dfs(arr[index++]);
        }
    }
}
