package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14438_수열과쿼리17 {
    static int[] seg, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        arr[0] = 1_000_000_001;

        int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        seg = new int[1 << high];
        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (c == 1) modify(1, 1, N, a, v);
            else sb.append(min(1, 1, N, a, v)).append("\n");
        }
        System.out.println(sb);

    }

    private static int init(int index, int start, int end) {
        if (start == end) return seg[index] = arr[start];
        int x = init(index * 2, start, (start + end) / 2);
        int y = init(index * 2 + 1, (start + end) / 2 + 1, end);
        return seg[index] = Math.min(x, y);
    }

    private static int min(int index, int start, int end, int findS, int findE) {
        if (findE < start || end < findS) return Integer.MAX_VALUE;
        if (findS <= start && end <= findE) return seg[index];
        int x = min(index * 2, start, (start + end) / 2, findS, findE);
        int y = min(index * 2 + 1, (start + end) / 2 + 1, end, findS, findE);
        return Math.min(x, y);
    }

    private static int modify(int index, int start, int end, int targetIndex, int value) {
        if (targetIndex < start || end < targetIndex) return seg[index];
        if (start == end) return seg[index] = value;

        int x = modify(index * 2, start, (start + end) / 2, targetIndex, value);
        int y = modify(index * 2 + 1, (start + end) / 2 + 1, end, targetIndex, value);
        return seg[index] = Math.min(x, y);
    }
}