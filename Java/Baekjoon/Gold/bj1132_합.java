package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class bj1132_합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] sum = new long[10][2];
        for (int i = 0; i < 10; i++) sum[i][1] = i;
        boolean[] zero = new boolean[10];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            zero[str.charAt(0) - 'A'] = true;
            int n = str.length();
            for (int j = 0; j < n; j++) {
                sum[str.charAt(j) - 'A'][0] += (long) Math.pow(10, n - 1 - j);
            }
        }

        Arrays.sort(sum, Comparator.comparingLong(value -> value[0]));

        int zeroIndex = -1;
        for (int i = 0; i < 10 && zeroIndex == -1; i++)
            if (!zero[(int)sum[i][1]]) zeroIndex = i;

        int value = 9;
        long result = 0;
        for (int i = 9; i >= 0; i--) {
            if (zeroIndex != i) {
                result += sum[i][0] * value--;
            }
        }
        System.out.println(result);
    }
}
