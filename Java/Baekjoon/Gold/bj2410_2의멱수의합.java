package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2410_2의멱수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0) arr[i] = (arr[i - 1] + arr[i / 2]) % 1_000_000_000;
            else arr[i] = arr[i -1];
        }
        System.out.println(arr[N]);
    }
}
