package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15824_너봄에는캡사이신이맛있단다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        long[] comb = new long[N];
        int DIV = 1_000_000_007;
        arr[0] = Integer.parseInt(st.nextToken());
        comb[0] = 1;
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            comb[i] = (comb[i - 1]-- * 2) % DIV;
        }
        comb[N - 1]--;
        comb[0] = 0;

        Arrays.sort(arr);

        long answer = 0;

        for (int i = 0; i < N; i++)
            answer = (answer + (comb[i] * arr[i]) - (comb[N - i - 1] * arr[i])) % DIV;

        System.out.println(answer);
    }
}