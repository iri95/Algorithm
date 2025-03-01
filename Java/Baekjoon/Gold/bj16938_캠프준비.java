package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj16938_캠프준비 {
    static int N, L, R, X, answer = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        comb(0, 0, -1);

        System.out.println(answer);
    }

    private static void comb(int index, int sum, int min) {
        if (sum >= L && sum <= R && arr[index - 1] - min >= X) answer++;

        for (int i = index; i < N; i++) {
            if (sum + arr[i] > R) return;
            comb(i + 1, sum + arr[i], min == -1 ? arr[i] : min);
        }
    }
}
