package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9426_중앙값측정 {
    static int N, K, size = 65535;
    static int[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tree = new int[1 << 17];

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < K - 1; i++) update(1, 0, size, arr[i], 1);

        int prev = 0;
        int mid = (K + 1) / 2;
        long answer = 0;
        for(int i = K - 1; i < N; i++){
            update(1, 0, size, arr[i], 1);
            answer += query(1, 0, size, mid);
            update(1, 0, size, arr[prev++], -1);
        }
        System.out.println(answer);

    }
    private static int update(int node, int start, int end, int index, int diff){
        if (index < start || end < index) return tree[node];
        if (start == end) return tree[node] += diff;
        return tree[node] = update(node * 2, start, (start + end) / 2, index, diff)
                + update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
    }

    private static int query(int node, int start, int end, int k){
        if (start == end) return start;

        if (tree[node * 2] >= k) return query(node * 2, start, (start + end) / 2, k);
        else return query(node * 2 + 1, (start + end) / 2 + 1, end, k - tree[2 * node]);

    }
}
