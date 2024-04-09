package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj5549_행성탐사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        char[][] map = new char[M + 1][N + 1];
        int[][][] count = new int[M + 1][N + 1][3];
        for (int i = 1; i <= M; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1);
                count[i][j][0] = count[i - 1][j][0] + count[i][j - 1][0] - count[i - 1][j - 1][0];
                count[i][j][1] = count[i - 1][j][1] + count[i][j - 1][1] - count[i - 1][j - 1][1];
                count[i][j][2] = count[i - 1][j][2] + count[i][j - 1][2] - count[i - 1][j - 1][2];
                if (map[i][j] == 'J') {
                    count[i][j][0] = count[i - 1][j][0] + count[i][j - 1][0] - count[i - 1][j - 1][0] + 1;
                } else if (map[i][j] == 'O') {
                    count[i][j][1] = count[i - 1][j][1] + count[i][j - 1][1] - count[i - 1][j - 1][1] + 1;
                } else {
                    count[i][j][2] = count[i - 1][j][2] + count[i][j - 1][2] - count[i - 1][j - 1][2] + 1;
                }
            }
        }

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[] cnt = new int[3];
            cnt[0] = count[c][d][0] - count[c][b - 1][0] - count[a - 1][d][0] + count[a - 1][b - 1][0];
            cnt[1] = count[c][d][1] - count[c][b - 1][1] - count[a - 1][d][1] + count[a - 1][b - 1][1];
            cnt[2] = count[c][d][2] - count[c][b - 1][2] - count[a - 1][d][2] + count[a - 1][b - 1][2];
            sb.append(cnt[0]).append(" ").append(cnt[1]).append(" ").append(cnt[2]).append("\n");
        }
        System.out.println(sb);
    }
}
