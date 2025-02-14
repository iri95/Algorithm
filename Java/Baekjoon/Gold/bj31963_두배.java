package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj31963_두배 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        long[] arr_cnt = new long[N];
        long answer = 0;
        for (int i = 1; i < N; i++) {
            long pow = (long) Math.ceil(Math.log((double) arr[i - 1] / arr[i]) / Math.log(2)) + arr_cnt[i - 1];

            if (pow > 0) {
                answer += pow;
                arr_cnt[i] = pow;
            }
        }
        System.out.println(answer);
    }
}
