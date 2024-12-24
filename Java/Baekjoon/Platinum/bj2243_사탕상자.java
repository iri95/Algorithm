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

        private int sum(int node, int start, int end, int findS, int findE) {
            if (findE < start || end < findS) return 0;
            if (findS <= start && end <= findE) return tree[node];
            return sum(node * 2, start, (start + end) / 2, findS, findE)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, findS, findE);
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
                int sum = 0;
                int start = 1;
                int end = INF;
                while(start < end){
                    int mid = (start + end) / 2;
                    int front = seg.sum(1, 1, INF, start, mid);
                    if (front + sum >= B) end = mid;
                    else {
                        sum += front;
                        start = mid + 1;
                    }
                }
                seg.update(1, 1, INF, end, -1);
                sb.append(end).append("\n");
            }
        }
        System.out.println(sb);
    }
}
