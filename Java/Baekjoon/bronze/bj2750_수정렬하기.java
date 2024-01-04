package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2750_수정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        for (int i = 0; i < N; i++) {
            System.out.println(list[i]);
        }
    }
}
