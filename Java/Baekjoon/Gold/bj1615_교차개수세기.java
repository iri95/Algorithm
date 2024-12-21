package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// java는 메모리 초과가 난다...
public class bj1615_교차개수세기 {
    private static class SegmentTree {
        int[] tree;

        private SegmentTree(int N) {
            int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
            tree = new int[1 << high];
        }

        private int update(int node, int start, int end, int index) {
            if (index < start || end < index) return tree[node];
            if (start == end) return tree[node] += 1;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        SegmentTree seg = new SegmentTree(N);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[] {a, b});
        }

        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int ans = 0;

        for (int[] ij : list) {
            ans += seg.sum(1, 1, N, ij[1] + 1, N);
            seg.update(1, 1, N, ij[1]);
        }

        System.out.println(ans);
    }
}
