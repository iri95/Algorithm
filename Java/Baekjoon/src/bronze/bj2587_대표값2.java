package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2587_대표값2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            list[i] = Integer.parseInt(br.readLine());
            sum += list[i];
        }
        System.out.println(sum / 5);
        Arrays.sort(list);
        System.out.println(list[2]);
    }
}
