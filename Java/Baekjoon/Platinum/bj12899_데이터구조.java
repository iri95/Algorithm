package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12899_데이터구조 {
    static int max = 2_000_000;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        int high = (int) Math.ceil(Math.log(max) / Math.log(2)) + 1;
        tree = new int[1 << high];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            if (T == 1) update(1, 1, max, X, 1);
            else sb.append(delete(1, 1, max, X)).append("\n");
        }
        System.out.println(sb);
    }

    private static int update(int node, int start, int end, int index, int diff) {
        if (index < start || end < index) return tree[node];
        if (start == end) return tree[node] += diff;

        return tree[node] = update(node * 2, start, (start + end) / 2, index, diff)
                + update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
    }

    private static int delete(int node, int start, int end, int value) {
        if (start == end) return start;

        if (value <= tree[node * 2]) {
            tree[node * 2]--;
            return delete(node * 2, start, (start + end) / 2, value);
        } else {
            tree[node * 2 + 1]--;
            return delete(node * 2 + 1, (start + end) / 2 + 1, end, value - tree[node * 2]);
        }
    }

}
