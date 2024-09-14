package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11505_구간곱구하기 {
    private static class SegmentTree {
        long[] tree;

        SegmentTree(int N) {
            double high = Math.ceil(Math.log(N) / Math.log(2)) + 1;
            int cnt = (int) Math.pow(2, high);
            tree = new long[cnt];
        }

        long init(int[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = arr[start];
            return tree[node] = init(arr, node * 2, start, (start + end) / 2)*
                    init(arr, node * 2 + 1, (start + end) / 2 + 1, end) % 1_000_000_007;
        }

        long mul(int node, int start, int end, int left, int right) {
            if (right < start || end < left) return 1;
            if (left <= start && end <= right) return tree[node] % 1_000_000_007;
            return mul(node * 2, start, (start + end) / 2, left, right) *
                    mul(node * 2 + 1, (start + end) / 2 + 1, end, left, right) % 1_000_000_007;
        }

        long update(int node, int start, int end, int index, long value) {
            if (index < start || end < index) return tree[node];
            if (start == index && end == index) return tree[node] = value;
            return tree[node] = update(node * 2, start, (start + end) / 2, index, value) *
                    update(node * 2 + 1, (start + end) / 2 + 1, end, index, value) % 1_000_000_007;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
        SegmentTree tree = new SegmentTree(N);
        tree.init(arr, 1, 1, N);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) tree.update(1, 1, N, b, c);
            else sb.append(tree.mul(1, 1, N, b, (int) c)).append("\n");
        }
        System.out.println(sb);
    }
}
