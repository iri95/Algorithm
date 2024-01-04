package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2751_수정렬하기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int a :list
             ) {
            sb.append(a + "\n");
        }
        System.out.println(sb);
    }
}
