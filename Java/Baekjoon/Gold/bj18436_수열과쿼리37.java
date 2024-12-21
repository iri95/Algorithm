package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18436_수열과쿼리37 {
    private static class SegmentTree {
        int[] tree;

        private SegmentTree(int N) {
            int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
            tree = new int[1 << high];
        }

        private int init(int[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start] % 2;
            return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                    + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
        }

        private int sum(int node, int start, int end, int findS, int findE) {
            if (findE < start || end < findS) return 0;
            if (findS <= start && end <= findE) return tree[node];
            return sum(node * 2, start, (start + end) / 2, findS, findE)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, findS, findE);
        }

        private int update(int node, int start, int end, int index, int diff) {
            if (index < start || end < index) return tree[node];
            if (start == end) return tree[node] = diff % 2;
            return tree[node] = update(node * 2, start, (start + end) / 2, index, diff)
                    + update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        SegmentTree seg = new SegmentTree(N);
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        seg.init(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (q == 1) seg.update(1, 1, N, a, b);
            else if (q == 2) sb.append(b - a + 1 - seg.sum(1, 1, N, a, b)).append("\n");
            else sb.append(seg.sum(1, 1, N, a, b)).append("\n");

        }
        System.out.println(sb);
    }
}
