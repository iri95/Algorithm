package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2116_주사위쌓기 {
    static int N;
    static int[] opposite = {5, 3, 4, 1, 2, 0};
    static int[][] maxValue, dices;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maxValue = new int[N][6];
        dices = new int[N][6];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++)
                dices[i][j] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 3; j++) {
                if (dices[i][j] + dices[i][opposite[j]] == 11)
                    maxValue[i][j] = maxValue[i][opposite[j]] = 4;
                else if (dices[i][j] == 6 || dices[i][opposite[j]] == 6)
                    maxValue[i][j] = maxValue[i][opposite[j]] = 5;
                else maxValue[i][j] = maxValue[i][opposite[j]] = 6;
            }
        }

        int result = 0;
        for (int i = 0; i < 6; i++)
            result = Math.max(result, sol(0, dices[0][i]));

        System.out.println(result);
    }

    private static int sol(int n, int bottom) {
        if (n == N) return 0;

        int bottomIndex = 0;
        for (int i = 0; i < 6; i++) {
            if (dices[n][i] == bottom) {
                bottomIndex = i;
                break;
            }
        }

        return sol(n + 1, dices[n][opposite[bottomIndex]]) + maxValue[n][bottomIndex];
    }
}
