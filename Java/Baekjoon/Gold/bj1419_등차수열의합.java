package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://coding-for-years.tistory.com/59
public class bj1419_등차수열의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());
        long result = 0;
        long start = 0;
        if (k == 2) {
            if (r < 3) result = 0;
            else {
                if (l < 3) result = r - 3 + 1;
                else result = r - l + 1;
            }
        } else if (k == 3 || k == 5) {
            start = (k * (k + 1)) / 2;
            if (start < l) {
                start += (((l - start) / k) + 1) * k;
                if (l % k == 0) start -= k;
            }
            if (start <= r) result = (r - start) / k + 1;
        } else if (k == 4) {
            if (1 <= l && l <= 10) {
                if (r < 10) result = 0;
                else {
                    start = 14;
                    if (start <= r) result = (r - start) / 2 + 1;
                    result++;
                }
            } else {
                start = 14;
                if (start < l) {
                    if (l % 2 == 0) start = l;
                    else start = l + 1;
                }
                if (start <= r) result = (r - start) / 2 + 1;
            }
        }
        System.out.println(result);
    }
}
