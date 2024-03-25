package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2230_수고르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int start = 0;
        int end = 0;
        int min = 2_000_000_001;
        while (start < N) {
            while(end < N && list[end] - list[start] < M) end++;
            if (end >= N) break;
            min = Math.min(list[end] - list[start], min);
            start++;
        }
        System.out.println(min);
    }
}
