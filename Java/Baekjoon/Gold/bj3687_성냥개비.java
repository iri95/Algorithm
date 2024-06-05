package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://escapefromcoding.tistory.com/147
public class bj3687_성냥개비 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt, T = Integer.parseInt(br.readLine());
        long[] dpMin = new long[101];
        String[] dpMax = new String[101];

        Arrays.fill(dpMin, Long.MAX_VALUE);
        dpMin[2] = 1;
        dpMin[3] = 7;
        dpMin[4] = 4;
        dpMin[5] = 2;
        dpMin[6] = 6;
        dpMin[7] = 8;
        dpMin[8] = 10;

        long[] nums = {1, 7, 4, 2, 0, 8};

        for (int i = 9; i <= 100; i++)
            for (int j = 2; j <= 7; j++)
                dpMin[i] = Math.min(dpMin[i - j] * 10 + nums[j - 2], dpMin[i]);

        dpMax[0] = "";
        dpMax[1] = "";

        for (int i = 2; i <= 100; i++) {
            dpMax[i] = i % 2 == 0 ? dpMax[i - 2] + "1" : "7" + dpMax[i - 3];
        }

        while (T-- > 0) {
            cnt = Integer.parseInt(br.readLine());
            sb.append(dpMin[cnt]).append(" ").append(dpMax[cnt]).append("\n");
        }
        System.out.println(sb);
    }
}