package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1337_올바른배열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int value = list[i];
            for (int j = i; j < i + 5 && j < N ; j++) {
                if(list[j] >= value && list[j] < value + 5)cnt++;
            }
            max = Math.max(max, cnt);
            cnt = 0;
        }
        System.out.println(5 - max);
    }
}
