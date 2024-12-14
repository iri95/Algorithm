package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10999_구간합구하기2 {
    private static class SegmentTree {
        long[] seg, lazy;

        public SegmentTree(int N) {
            int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
            seg = new long[1 << high];
            lazy = new long[1 << high];
        }

        public long init(long[] arr, int node, int start, int end) {
            if (start == end) return seg[node] = arr[start];
            return seg[node] = init(arr, node * 2, start, (start + end) / 2)
                    + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
        }

        // 노드에 lazy를 적용하는 함수.
        public void update_lazy(int node, int start, int end) {
            if (lazy[node] == 0) return;
            seg[node] += (end - start + 1) * lazy[node]; // 탬색 노드의 하위 노드들의 개수만큼 트리에 lazy 값을 더해준다.

            // 만약 리프 노드가 아니라면 하위 노드의 lazy 값에 탐색 노드의 lazy 값을 더해준다.
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0; // 현재 탐색 노드의 lazy 값을 트리에 적용했기 때문에 0으로 초기화 해준다.
        }

        // 구간 합을 반환하는 함수
        public long sum(int node, int start, int end, int findS, int findE) {
            // sum하기 전에 탐색 노드의 lazy를 적용시켜 준다.
            update_lazy(node, start, end);
            if (findE < start || end < findS) return 0;
            if (findS <= start && end <= findE) return seg[node];
            return sum(node * 2, start, (start + end) / 2, findS, findE)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, findS, findE);
        }

        // 트리의 값을 update하는 함수
        public long update(int node, int start, int end, int updateS, int updateE, long diff) {
            // update하기 전에 탐색 노드의 lazy를 적용시켜 준다.
            update_lazy(node, start, end);
            if (updateE < start || end < updateS) return seg[node];
            if (updateS <= start && end <= updateE) {
                // update 함수는 여기서 return 되므로 하위 노드의 lazy 값에 diff를 더해준다.
                if (start != end) {
                    lazy[node * 2] += diff;
                    lazy[node * 2 + 1] += diff;
                }
                return seg[node] += (end - start + 1) * diff;
            }
            return seg[node] = update(node * 2, start, (start + end) / 2, updateS, updateE, diff)
                    + update(node * 2 + 1, (start + end) / 2 + 1, end, updateS, updateE, diff);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 배열 초기화
        long[] arr = new long[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Long.parseLong(br.readLine());

        // 세그먼트 트리 객체 초기화
        SegmentTree tree = new SegmentTree(N);
        tree.init(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            if (p == 1) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                tree.update(1, 1, N, s, e, d);
            } else {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                sb.append(tree.sum(1, 1, N, s, e)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
