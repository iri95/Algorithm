package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1339_단어수학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int n = str.length();
            for (int j = 1; j <= n; j++) arr[str.charAt(j - 1) - 'A'] += (int) Math.pow(10, n - j);
        }
        Arrays.sort(arr);
        int result = 0;
        for (int i = 25; i > 15; i--) result += arr[i] * (i - 16);
        System.out.println(result);
    }
}
