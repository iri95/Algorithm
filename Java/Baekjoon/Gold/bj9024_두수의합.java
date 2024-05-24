package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj9024_두수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int n, k, start, end, sum, min, count;
        int[] list;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            list = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            min = Integer.MAX_VALUE;
            Arrays.sort(list);
            start = 0;
            end = n - 1;
            while (start < end) {
                sum = list[start] + list[end];
                if (Math.abs(k - sum) < min) {
                    count = 1;
                    min = Math.abs(k - sum);
                } else if (Math.abs(k - sum) == min) count++;

                if (sum > k) end--;
                else start++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
