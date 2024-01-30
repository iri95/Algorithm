package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17140_이차원배열과연산 {
    static int maxR = 3;
    static int maxC = 3;
    static int[][] map = new int[100][100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 열
        int c = Integer.parseInt(st.nextToken()); // 행
        int k = Integer.parseInt(st.nextToken());
        map = new int[100][100];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxR = 3;
        maxC = 3;
        int time = 0;
        if (map[r - 1][c - 1] == k) {
            System.out.println(0);
            return;
        }
        while (time++ < 100) {
            if (maxC <= maxR) R();
            else C();
            if (map[r - 1][c - 1] == k) {
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }

    static void R() {
        for (int i = 0; i < maxR; i++) {
            int[] visit = new int[101];
            int max = 0;
            int numberMax = 0;
            for (int j = 0; j < maxC; j++) {
                visit[map[i][j]]++;
                numberMax = Math.max(numberMax, map[i][j]);
                max = Math.max(max, visit[map[i][j]]);
            }
            int count = 0;
            for (int j = 1; j <= max; j++) {
                for (int k = 1; k <= numberMax; k++) {
                    if (visit[k] == j) {
                        map[i][count * 2] = k;
                        map[i][count * 2 + 1] = j;
                        count++;
                    }
                }
            }
            for (int j = count * 2; j < 100; j++) {
                map[i][j] = 0;
            }
            maxC = Math.max(maxC, count * 2);
        }
    }

    static void C() {
        for (int i = 0; i < maxC; i++) {
            int[] visit = new int[101];
            int max = 0;
            int numberMax = 0;
            for (int j = 0; j < maxR; j++) {
                visit[map[j][i]]++;
                numberMax = Math.max(numberMax, map[j][i]);
                max = Math.max(max, visit[map[j][i]]);
            }
            int count = 0;
            for (int j = 1; j <= max; j++) {
                for (int k = 1; k <= numberMax; k++) {
                    if (visit[k] == j) {
                        map[count * 2][i] = k;
                        map[count * 2 + 1][i] = j;
                        count++;
                    }
                }
            }
            for (int j = count * 2; j < 100; j++) {
                map[j][i] = 0;
            }
            maxR = Math.max(count * 2, maxR);
        }
    }
}
