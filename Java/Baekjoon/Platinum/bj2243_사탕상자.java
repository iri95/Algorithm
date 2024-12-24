package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2243_사탕상자 {
    private static class SegmentTree {
        int[] tree;

        private SegmentTree() {
            int high = (int) Math.ceil(Math.log(INF) / Math.log(2)) + 1;
            tree = new int[1 << high];
        }

        private int update(int node, int start, int end, int index, int diff) {
            if (index < start || end < index) return tree[node];
            if (start == end) return tree[node] += diff;
            return tree[node] = update(node * 2, start, (start + end) / 2, index, diff)
                    + update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }

        private int query(int node, int start, int end, int target) {
            if (start == end) {
                update(1, 1, INF, start, -1);
                return start;
            }
            int mid = (start + end) / 2;
            if (target <= tree[node * 2]) return query(node * 2, start, mid, target);
            else return query(node * 2 + 1, mid + 1, end, target - tree[node * 2]);
        }
    }

    static int INF = 1_000_000;
    static SegmentTree seg = new SegmentTree();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            if (A == 2) {
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                seg.update(1, 1, INF, B, C);
            } else {
                int B = Integer.parseInt(st.nextToken());
                sb.append(seg.query(1, 1, INF, B)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
