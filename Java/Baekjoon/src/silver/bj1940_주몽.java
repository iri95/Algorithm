package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1940_주몽 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int start = 0;
        int end = N - 1;
        int cnt = 0;
        while (start < end) {
            if (list[start] + list[end] > M) {
                end--;
            } else if (list[start] + list[end] < M) {
                start++;
            } else if (list[start] + list[end] == M) {
                cnt++;
                end--;
                start++;
            }
        }
        System.out.println(cnt);
    }
}
