package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj19951_태상이의훈련소생활 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) list[i] = Integer.parseInt(st.nextToken());
        int[] sum = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sum[a] += c;
            if (b < N) sum[b + 1] -= c;
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += sum[i];
            list[i] += cnt;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(list[i]).append(" ");
        System.out.println(sb);


    }
}
