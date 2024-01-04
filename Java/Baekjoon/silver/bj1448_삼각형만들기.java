package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class bj1448_삼각형만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int result = -1;
        for (int i = N - 1; i >= 2; i--) {
            if (list[i] < list[i - 1] + list[i - 2]) {
                result = list[i] + list[i-1] + list[i-2];
                break;
            }
        }
        System.out.println(result);

    }
}
