package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10986_나머지합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] remain = new long[M];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Integer.parseInt(st.nextToken()) % M;
            remain[sum % M]++;
        }
        long count = remain[0];
        for (int i = 0; i < M; i++) {
            if (remain[i] > 1) count += (remain[i] * (remain[i] - 1)) / 2;
        }
        System.out.println(count);
    }
}
