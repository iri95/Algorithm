package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11812_K진트리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // i의 마지막 자식은 K * i + 1 이다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        // 1 / 2 3 4 5 6 7 / 8 9 10 11 12 13, 14 ~ 19, 20 ~ 25, 26 ~ 31, 32 ~ 37, 38 ~ 43/ 44 ~ 49
        // 여기에 K - 2를 더하면? 0 / 1 / 2 ~ 7 /
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (K == 1){
                sb.append(Math.abs(b - a)).append("\n");
                continue;
            }
            long ah = getH(a, K);
            long bh = getH(b, K);
            if (ah < bh) {
                long temp = a;
                a = b;
                b = temp;
                temp = ah;
                ah = bh;
                bh = temp;
            }
            int cnt = 0;
            while (ah > bh) {
                cnt++;
                a += K - 2;
                a /= K;
                ah--;
            }
            if (a == b) sb.append(cnt).append("\n");
            else {
                while (a != b) {
                    cnt += 2;
                    a += K - 2;
                    b += K - 2;
                    a /= K;
                    b /= K;
                }
                sb.append(cnt).append("\n");
            }
        }
        System.out.println(sb);
    }
    private static long getH(long a, int K){
        int cnt = 0;
        while(a != 0){
            a += K - 2;
            a /= K;
            cnt++;
        }
        return cnt;
    }
}
