package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1041_주사위 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] list = new long[6];
        for (int i = 0; i < 6; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        long sum2 = Math.min(list[0] + list[1], Math.min(list[0] + list[2], Math.min(list[0] + list[3], Math.min(list[0] + list[4],
                        Math.min(list[5] + list[1], Math.min(list[5] + list[2], Math.min(list[5] + list[3], Math.min(list[5] + list[4],
                                Math.min(list[1] + list[2], Math.min(list[1] + list[3], Math.min(list[2] + list[4], list[4] + list[3])))))))))));

        long sum3 = Math.min(list[0] + list[1] + list[2], Math.min(list[0] + list[2] + list[4], Math.min(list[0] + list[3] + list[4], Math.min(list[0] + list[1] + list[3],
                Math.min(list[5] + list[1] + list[2], Math.min(list[5] + list[2] + list[4], Math.min(list[5] + list[3] + list[4], list[5] + list[1] + list[3])))))));

        Arrays.sort(list);
        if (N == 1) {
            System.out.println(list[0] + list[1] + list[2] + list[3] + list[4]);
            return;
        }
        long sum = 0;
        sum += list[0] * ((N - 1) * (N - 2) * 4 + (N - 2) * (N - 2));
        sum += sum2 * ((2 * N - 3) * 4);
        sum += sum3 * 4;
        System.out.println(sum);

        /*
            1 -> 5개
            2 -> 1개 1 * 0 * 4 0,    2개 1 * 4 + 0 * 4 4,         3개 4
            3 -> 1개 2 * 1 * 4  + (N - 2)^2 9,    2개 2 * 4 + 1 * 4 12,    3개 4
            4 -> 1개 3 * 2  * 4 24,  2개 3 * 4 + 2 * 4 20,    3개 4
            5 -> 1개 4 * 3 * 4 48,   2개 4 * 4 + 3 * 4 28,    3개 4
            1면 : (N -1) * (N -2) * 4 + (N - 2) ^ 2
            2면 : (N - 1 + N - 2) * 4
            3면 : 4
         */
    }
}
