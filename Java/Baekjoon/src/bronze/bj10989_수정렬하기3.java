package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10989_수정렬하기3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (int value : array
             ) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}
