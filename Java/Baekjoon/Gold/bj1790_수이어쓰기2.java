package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1790_수이어쓰기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int len = 0;
        long cnt = 9;
        while (N > 0) {
            len += N;
            N -= (int) cnt;
            cnt *= 10;
        }

        if (k > len) {
            System.out.println(-1);
            return;
        }

        cnt = 9;
        long c = 1;
        while (cnt * c < k) {
            k -= (int) (cnt * c++);
            cnt *= 10;
        }

        cnt /= 9;
        int num = (int) (k / c);
        int remain = (int) (k % c);
        String result = String.valueOf(cnt + (remain == 0 ? num - 1 : num));
        System.out.println(result.charAt(remain == 0 ? (int) c - 1 : remain - 1));
    }
}
