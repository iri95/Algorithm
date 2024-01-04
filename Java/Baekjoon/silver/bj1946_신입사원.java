package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1946_신입사원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] list = new int[N+1];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            int cnt = 1;
            int min = list[1];
            for (int i = 2; i <= N; i++) {
                if (list[i] < min) {
                    cnt++;
                    min = list[i];
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
