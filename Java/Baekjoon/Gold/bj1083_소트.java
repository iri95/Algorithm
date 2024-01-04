package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1083_소트 {
    static int[] list;
    static int N, S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        S = Integer.parseInt(br.readLine());
        int a = 0;
        while (S > 0 && a < N - 1) {
            int k = max(a, S);
            if (k == a) {
                a++;
                continue;
            }
            S = S - k + a;
            for (int i = k; i > a; i--) {
                sort(i, i-1);
            }
            a++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(list[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void sort(int a, int b) {
        int k = list[a];
        list[a] = list[b];
        list[b] = k;
    }

    static int max(int a, int b){
        int max = 0;
        int result = 0;
        for (int i = a; i <= a + b && i < N; i++) {
            if (max < list[i]) {
                max = list[i];
                result = i;
            }
        }
        return result;
    }
}
