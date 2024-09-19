package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2357_최솟값과최댓값 {
    private static class SegmentTree {
        int[][] tree;

        public SegmentTree(int N) {
            double high = Math.ceil(Math.log(N) / Math.log(2)) + 1;
            int cnt = (int) Math.pow(2, high);
            tree = new int[cnt][2]; // 최솟값, 최댓값
        }

        public int[] init(int[] arr, int node, int start, int end) {
            if (start == end) return tree[node] = new int[]{arr[start], arr[end]};

            int[] a = init(arr, node * 2, start, (start + end) / 2);
            int[] b = init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            return tree[node] = new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        }

        public int[] result(int node, int start, int end, int left, int right) {
            if (start > right || end < left) return new int[]{1_000_000_001, 0};
            else if (left <= start && end <= right) return tree[node];
            else {
                int[] a = result(node * 2, start, (start + end) / 2, left, right);
                int[] b = result(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
                return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
        SegmentTree seg = new SegmentTree(N);
        seg.init(arr, 1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] ans = seg.result(1, 1, N, a, b);
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }
        System.out.println(sb);
    }
}
