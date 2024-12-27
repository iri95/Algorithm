package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12837_가계부Hard {
    private static class SegmentTree {
        long[] tree;

        SegmentTree(int N) {
            int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
            tree = new long[1 << high];
        }

        long update(int node, int start, int end, int index, int diff) {
            if (index < start || end < index) return tree[node];
            if (start == end) return tree[node] += diff;
            return tree[node] = update(node * 2, start, (start + end) / 2, index, diff)
                    + update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }

        long sum(int node, int start, int end, int findS, int findE) {
            if (findE < start || end < findS) return 0;
            if (findS <= start && end <= findE) return tree[node];
            return sum(node * 2, start, (start + end) / 2, findS, findE)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, findS, findE);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        SegmentTree seg = new SegmentTree(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (num == 1) seg.update(1, 1, N, a, b);
            else sb.append(seg.sum(1, 1, N, a, b)).append("\n");
        }
        System.out.println(sb);
    }
}
