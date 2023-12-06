package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11501_주식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] list = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            int max = list[N];
            for (int i = N - 1; i > 0; i--) {
                if (list[i] < max) {
                    sum += max - list[i];
                } else {
                    max = list[i];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
