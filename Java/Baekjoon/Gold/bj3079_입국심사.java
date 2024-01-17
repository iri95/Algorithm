package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj3079_입국심사 {
    static int N, M;
    static long[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new long[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        long start = 1;
        long end = list[0] * M + 1;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (getCount(mid) >= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(end + 1);
    }

    private static long getCount(long mid) {
        long count = 0;
        for (int i = 0; i < N; i++) {
            count += mid / list[i];
        }
        return count;
    }
}
