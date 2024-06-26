package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1561_놀이공원 {
    static int N, M;
    static int[] times;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if (N <= M) {
            System.out.println(N);
            return;
        } else N -= M;
        times = new int[M + 1];
        long s = 0;
        long e = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            e = Math.max(e, (long) times[i] * N);
        }
        while (s < e) {
            long mid = (s + e) / 2;
            if (binary(mid) >= N) e = mid;
            else s = mid + 1;
        }
        int ans = 0;
        long count = binary(e - 1);
        for (int i = 1; i <= M; i++) {
            if (e % times[i] == 0) {
                ans = i;
                count++;
            }
            if (count == N) break;
        }
        System.out.println(ans);
    }

    private static long binary(long time) {
        long count = 0;
        for (int i = 1; i <= M; i++) count += time / times[i];
        return count;
    }
}
