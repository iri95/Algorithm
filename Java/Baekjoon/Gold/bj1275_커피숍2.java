package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1275_커피숍2 {
    static int N;
    static long[] tree, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        init();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Long.parseLong(st.nextToken());
        setting(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (s > e) {
                int temp = s;
                s = e;
                e = temp;
            }
            int index = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(sum(1, 1, N, s, e)).append("\n");
            update(1, 1, N, index, v);
        }
        System.out.println(sb);

    }

    private static void init() {
        int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        tree = new long[(int) Math.pow(2, high)];
    }

    private static long setting(int index, int start, int end) {
        if (start == end) return tree[index] = arr[start];
        return tree[index] = setting(index * 2, start, (start + end) / 2) + setting(index * 2 + 1, (start + end) / 2 + 1, end);
    }

    private static long sum(int index, int start, int end, int left, int right) {
        if (start > right || end < left) return 0;
        if (left <= start && end <= right) return tree[index];
        return sum(index * 2, start, (start + end) / 2, left, right) + sum(index * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    private static long update(int index, int start, int end, int arrIndex, long value) {
        if (arrIndex < start || end < arrIndex) return tree[index];
        if (start == arrIndex && end == arrIndex) return tree[index] = value;
        return tree[index] = update(index * 2, start, (start + end) / 2, arrIndex, value) + update(index * 2 + 1, (start + end) / 2 + 1, end, arrIndex, value);
    }
}
