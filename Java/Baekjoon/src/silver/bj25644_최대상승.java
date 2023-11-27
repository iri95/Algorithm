package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj25644_최대상승 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int min = list[0];
        int max = 0;
        for (int i = 1; i < N; i++) {
            min = Math.min(min, list[i]);
            if (min < list[i]) {
                max = Math.max(list[i] - min, max);
            }
        }
        System.out.println(max);
    }
}
