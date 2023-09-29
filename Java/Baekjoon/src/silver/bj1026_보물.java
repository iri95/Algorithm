package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1026_보물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] listA = new int[N];
        int[] listB = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            listA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            listB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(listA);
        Arrays.sort(listB);
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += listA[i] * listB[N - i - 1];
        }
        System.out.println(S);
    }
}
