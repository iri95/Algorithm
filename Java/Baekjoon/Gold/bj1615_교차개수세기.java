package Gold;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj1615_교차개수세기 {
    private static class SegmentTree {
        int[] tree;

        private SegmentTree(int N) {
            int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
            tree = new int[1 << high];
        }

        private int update(int node, int start, int end, int index) {
            if (index < start || end < index) return tree[node];
            if (start == end) return tree[node]++;
            return tree[node] = update(node * 2, start, (start + end) / 2, index)
                    + update(node * 2 + 1, (start + end) / 2 + 1, end, index);
        }

        private int sum(int node, int start, int end, int left, int right) {
            if (right < start || end < left) return 0;
            if (left <= start && end <= right) return tree[node];
            return sum(node * 2, start, (start + end) / 2, left, right)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }
    }

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        SegmentTree seg = new SegmentTree(N);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            list.add(new int[]{a, b});
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        long ans = 0;

        for (int[] ij : list) {
            ans += seg.sum(1, 1, N, ij[1] + 1, N);
            seg.update(1, 1, N, ij[1]);
        }

        System.out.println(ans);
    }

    private static int read() throws IOException {
        int n = 0;
        int i;
        while ((i = System.in.read()) >= '0')
            n = (n << 3) + (n << 1) + (i & 15);

        return n;
    }
}
