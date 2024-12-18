package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj7578_공장 {
    private static class SegmentTree {
        long[] tree;

        private SegmentTree(int N) {
            int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
            tree = new long[1 << high];
        }

        private long update(int node, int start, int end, int index, int diff) {
            if (index < start || end < index) return tree[node];
            if (start == end) return tree[node] += diff;
            return tree[node] = update(node * 2, start, (start + end) / 2, index, diff)
                    + update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }

        private long sum(int node, int start, int end, int findS, int findE) {
            if (findE < start || end < findS) return 0;
            if (findS <= start && end <= findE) return tree[node];
            return sum(node * 2, start, (start + end) / 2, findS, findE)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, findS, findE);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        SegmentTree tree = new SegmentTree(N);
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) map.put(Integer.parseInt(st.nextToken()), i);
        st = new StringTokenizer(br.readLine());
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            cnt += tree.sum(1, 1, N, map.get(a) + 1, N);
            tree.update(1, 1, N, map.get(a), 1);
        }
        System.out.println(cnt);
    }
}
