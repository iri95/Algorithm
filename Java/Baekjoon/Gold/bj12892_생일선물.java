package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj12892_생일선물 {
    static int N, D;
    static int[][] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] =Integer.parseInt(st.nextToken());
            list[i][1] =Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list, Comparator.comparing(o -> o[0]));
        long[] sum = new long[N + 1];
        for (int i = 1; i <= N; i++) sum[i] = sum[i - 1] + list[i][1];
        long max = 0;
        for (int i = 1; i <= N; i++) {
            int index = binary(list[i][0] + D);
            max = Math.max(max, sum[index] - sum[i - 1]);
        }
        System.out.println(max);

    }
    static int binary(int n){
        int start = 0;
        int end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (list[mid][0] < n) start = mid + 1;
            else end = mid - 1;
        }
        return start - 1;
    }
}
