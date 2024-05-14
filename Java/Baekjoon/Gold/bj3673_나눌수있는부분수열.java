package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj3673_나눌수있는부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int d, n;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            long[] remain = new long[d];
            long sum = 0;
            long count = 0;
            st = new StringTokenizer(br.readLine());
            while (n-- > 0) {
                sum += Long.parseLong(st.nextToken());
                int k = (int) (sum % d);
                if (k == 0) count++;
                count += remain[k]++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
