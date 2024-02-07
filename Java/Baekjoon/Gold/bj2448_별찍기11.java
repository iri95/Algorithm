package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2448_별찍기11 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 5 * N / 3 + N / 3 - 1
        int bottom = 6 * N / 3 - 1;
        String[][] str = new String[N][bottom];
        int half = bottom / 2;
        str[0][half] = "*";
        str[1][half - 1] = "*";
        str[1][half + 1] = "*";
        Arrays.fill(str[2], half-2, half+3, "*");
        int start = 3;
        while (start < N) {
            for (int i = 0; i < start; i++) {
                for (int j = half - start + 1; j < half + start; j++) {
                    str[i + start][j - start] = str[i][j];
                    str[i + start][j + start] = str[i][j];
                }
            }
            start *= 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < bottom; j++) {
                if (str[i][j] == null) sb.append(" ");
                else sb.append(str[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
