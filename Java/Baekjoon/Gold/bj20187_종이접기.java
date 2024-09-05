package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20187_종이접기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = (int) Math.pow(2, k);
        int[][] map = new int[n][n];
        int y = 0;
        int x = 0;
        int Ycnt = n;
        int Xcnt = n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * k; i++) {
            char c = st.nextToken().charAt(0);
            if (c == 'R' || c == 'L') Xcnt /= 2;
            if (c == 'U' || c == 'D') Ycnt /= 2;
            if (c == 'R') x += Xcnt;
            else if (c == 'D') y += Ycnt;
        }
        int h = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        /* 2 X 2 종이에서 제일 아래 위치하는 칸
        왼쪽 위, h < 2 || 왼쪽 아래, h >= 2
        왼쪽 위, h >= 2 || 왼쪽 아래, h < 2
        오른쪽 위, h < 2 || 오른쪽 아래, h >= 2
        오른쪽 위, h >= 2 || 오른쪽 아래, h < 2
         */
        if ((y % 2 == 0 && x % 2 == 0 && h < 2) || (y % 2 == 1 && x % 2 == 0 && h >= 2)) {
            for (int i = 0; i < n; i += 2) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = (j + h) % 2;
                    map[i + 1][j] = (j + h) % 2 + 2;
                }
            }
        } else if ((y % 2 == 0 && x % 2 == 0 && h >= 2) || (y % 2 == 1 && x % 2 == 0 && h < 2)) {
            for (int i = 0; i < n; i += 2) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = (j + h) % 2 + 2;
                    map[i + 1][j] = (j + h) % 2;
                }
            }
        } else if ((y % 2 == 0 && x % 2 == 1 && h < 2) || (y % 2 == 1 && x % 2 == 1 && h >= 2)) {
            for (int i = 0; i < n; i += 2) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = (j + h + 1) % 2;
                    map[i + 1][j] = (j + h + 1) % 2 + 2;
                }
            }
        } else {
            for (int i = 0; i < n; i += 2) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = (j + h + 1) % 2 + 2;
                    map[i + 1][j] = (j + h + 1) % 2;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
