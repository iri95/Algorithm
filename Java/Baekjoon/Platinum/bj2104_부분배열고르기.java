package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2104_부분배열고르기 {
    private static class SegmentTree {
        long[][] tree;

        SegmentTree(int n) {
            int high = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
            tree = new long[1 << high][3];
        }

        public long[] init(int node, int start, int end, int[] arr) {
            if (start == end) {
                tree[node][0] = arr[start];
                tree[node][1] = arr[start];
                tree[node][2] = start;
                return tree[node];
            }
            long[] L = init(node * 2, start, (start + end) / 2, arr);
            long[] R = init(node * 2 + 1, (start + end) / 2 + 1, end, arr);
            tree[node][0] = L[0] + R[0];
            if (L[1] > R[1]) {
                tree[node][1] = R[1];
                tree[node][2] = R[2];
            } else {
                tree[node][1] = L[1];
                tree[node][2] = L[2];
            }

            return tree[node];
        }

        public long[] query(int node, int start, int end, int left, int right) {
            if (end < left || right < start) return new long[]{0, Integer.MAX_VALUE};
            if (left <= start && end <= right) return tree[node];
            long[] L = query(node * 2, start, (start + end) / 2, left, right);
            long[] R = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            tree[node][0] = L[0] + R[0];
            if (L[1] > R[1]) {
                tree[node][1] = R[1];
                tree[node][2] = R[2];
            } else {
                tree[node][1] = L[1];
                tree[node][2] = L[2];
            }
            return tree[node];
        }

    }
    static int N;
    static SegmentTree seg;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        seg = new SegmentTree(N);
        seg.init(1, 1, N, arr);
        System.out.println(sol(1, N));
    }

    private static long sol(int s, int e) {
        long[] target = seg.query(1, 1, N, s, e);
        long result = target[0] * target[1];

        if (target[2] - 1 >= s)
            result = Math.max(result, sol(s, (int) target[2] - 1));

        if (target[2] + 1 <= e)
            result = Math.max(result, sol((int) target[2] + 1, e));

        return result;

    }
}
