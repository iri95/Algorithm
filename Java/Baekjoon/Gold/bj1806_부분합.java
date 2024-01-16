package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1806_부분합 {
    static int N, S;
    static int[] list, sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new int[N + 1];
        sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + list[i];
        }
        if (sum[N] < S) {
            System.out.println(0);
            return;
        }
        int a = 0;
        int b = 1;
        int min = N + 1;
        while (b <= N) {
            if (sum[b] - sum[a] >= S) {
                min = Math.min(b - a, min);
                a++;
            }else{
                b++;
            }
        }
        System.out.println(min);
    }
}
