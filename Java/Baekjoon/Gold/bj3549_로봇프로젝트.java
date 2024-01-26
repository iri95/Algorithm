package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj3549_로봇프로젝트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        // 1cm = 10_000_000nm
        String str = "";
        while ((str = br.readLine()) != null) {
            int x = Integer.parseInt(str) * 10_000_000;
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(list);
            boolean flag = false;
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int sum = list[start] + list[end];
                if (sum == x) {
                    flag = true;
                    break;
                }
                if (sum > x) end--;
                else start++;
            }
            if (!flag) System.out.println("danger");
            else System.out.println("yes " + list[start] + " " + list[end]);
        }
    }
}
