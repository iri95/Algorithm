package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2268_수들의합7 {
    static int N, M;
    static long[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        tree = new long[1 << high];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (b > c) sb.append(sum(1, 1, N, c, b)).append("\n");
                else sb.append(sum(1, 1, N, b, c)).append("\n");
            } else modify(1, 1, N, b, c);
        }
        System.out.println(sb);
    }

    private static long sum(int n, int start, int end, int tStart, int tEnd) {
        if (tEnd < start || end < tStart) return 0;
        if (tStart <= start && end <= tEnd) return tree[n];
        return sum(2 * n, start, (start + end) / 2, tStart, tEnd)
                + sum(2 * n + 1, (start + end) / 2 + 1, end, tStart, tEnd);
    }

    private static long modify(int n, int start, int end, int target, int value) {
        if (target < start || end < target) return tree[n];
        if (start == end) return tree[n] = value;
        return tree[n] = modify(2 * n, start, (start + end) / 2, target, value)
                + modify(2 * n + 1, (start + end) / 2 + 1, end, target, value);
    }
}
