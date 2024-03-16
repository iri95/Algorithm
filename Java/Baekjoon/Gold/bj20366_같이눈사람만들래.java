package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj20366_같이눈사람만들래 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > i + 2; j--) {
                int start = i + 1;
                int end = j - 1;
                while (start < end) {
                    int k = (list[end] + list[start]) - (list[j] + list[i]);
                    result = Math.min(Math.abs(k), result);
                    if (k < 0) start++;
                    else if (k > 0) end--;
                    else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
