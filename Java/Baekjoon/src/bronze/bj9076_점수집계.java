package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj9076_점수집계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int[] list = new int[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(list);
            if (list[3] - list[1] >= 4) {
                sb.append("KIN").append("\n");
            }else{
                sb.append(list[1] + list[2] + list[3]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
