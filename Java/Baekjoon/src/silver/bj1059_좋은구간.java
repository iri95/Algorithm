package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1059_좋은구간 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] list = new int[L];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());
        Arrays.sort(list);
        for (int i = 0; i < L; i++) {
            if (list[i] == n) {
                System.out.println(0);
                break;
            }
            if (list[i] < n) {
                continue;
            }
            if (list[i] > n) {
                if (i == 0) {
                    System.out.println(n * (list[0] - n) - 1);
                    break;
                }else{
                    System.out.println((n - list[i-1]) * (list[i] - n) - 1);
                    break;
                }
            }
        }
    }

}
