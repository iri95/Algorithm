package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj269_N번째큰수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] list = new int[10];
            for (int j = 0; j < 10; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(list);
            sb.append(list[7]).append("\n");
        }
        System.out.println(sb);
    }
}
