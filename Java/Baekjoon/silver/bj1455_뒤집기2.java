package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1455_뒤집기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] count = new int[M];
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == '0') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if ((map[i][j] + count[j]) % 2 != 0) {
                    answer++;
                    for (int k = j; k >= 0; k--) {
                        count[k]++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
