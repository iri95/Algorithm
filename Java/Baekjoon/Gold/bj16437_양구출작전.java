package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj16437_양구출작전 {
    static int N;
    static long[] arr;
    static List<Integer>[] child;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        child = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) child[i] = new ArrayList<>();
        arr = new long[N + 1];

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            child[next].add(i);
            if (t == 'W') cnt *= -1;
            arr[i] = cnt;
        }

        dfs(1, -1);

        System.out.println(arr[1]);
    }

    private static void dfs(int n, int p) {
        for (int next : child[n]) dfs(next, n);

        if (p != -1)
            if (arr[n] > 0)
                arr[p] += arr[n];
    }
}
