package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class bj1758_알바생강호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        long result = 0;
        for (int i = 0; i < N; i++) {
            int a = list[N - i - 1] - i;
            if (a > 0) {
                result += a;
            }
        }
        System.out.println(result);
    }
}
