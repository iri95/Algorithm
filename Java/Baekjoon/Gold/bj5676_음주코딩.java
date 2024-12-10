package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj5676_음주코딩 {

    static int[] seg, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i] = Integer.compare(a, 0);
            }

            int high = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
            seg = new int[1 << high];
            init(1, 1, N);
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals("C")) {
                    int targetIndex = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    value = Integer.compare(value, 0);
                    modify(1, 1, N, targetIndex, value);
                } else {
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    int a = findIndex(1, 1, N, s, e);
                    if (a > 0) sb.append('+');
                    else if (a == 0) sb.append('0');
                    else sb.append('-');
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int init(int index, int start, int end) {
        if (start == end) return seg[index] = arr[start];
        return seg[index] = init(index * 2, start, (start + end) / 2) * init(index * 2 + 1, (start + end) / 2 + 1, end);
    }

    private static int findIndex(int index, int start, int end, int findS, int findE) {
        if (findE < start || end < findS) return 1;
        if (findS <= start && end <= findE) return seg[index];
        return findIndex(index * 2, start, (start + end) / 2, findS, findE)
                * findIndex(index * 2 + 1, (start + end) / 2 + 1, end, findS, findE);
    }

    private static int modify(int index, int start, int end, int targetIndex, int value) {
        if (start > targetIndex || end < targetIndex) return seg[index];
        if (start == end) return seg[index] = value;
        return seg[index] = modify(index * 2, start, (start + end) / 2, targetIndex, value)
                * modify(index * 2 + 1, (start + end) / 2 + 1, end, targetIndex, value);
    }
}
