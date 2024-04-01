package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj2170_선긋기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list, Comparator.comparingInt(o -> o[0]));
        long sum = 0;
        long start = list[0][0];
        long end = list[0][1];
        for (int i = 1; i < N; i++) {
            if (end >= list[i][0]) {
                if (end < list[i][1]) {
                    end = list[i][1];
                }
            }else{
                sum += end - start;
                start = list[i][0];
                end = list[i][1];
            }
        }
        sum += end - start;
        System.out.println(sum);
    }
}
