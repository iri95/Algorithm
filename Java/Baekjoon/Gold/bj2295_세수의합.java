package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2295_세수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int start = 0;
                int end = j;
                while (start <= end) {
                    if (list[start] + list[end] > list[i] - list[j]) end--;
                    else if (list[start] + list[end] < list[i] - list[j]) start++;
                    else {
                        System.out.println(list[i]);
                        return;
                    }
                }
            }
        }
    }
}
