package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj18808_스티커붙이기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            boolean[][] sticker = new boolean[r][c];
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    sticker[j][k] = st.nextToken().equals("1");
                }
            }
            for (int t = 0; t < 4; t++) {
                boolean hit = false;
                for (int j = 0; j + r - 1 < N; j++) {       // 시작행
                    for (int k = 0; k + c - 1 < M; k++) {   // 시작열
                        boolean can = true;
                        for (int l = j; l < j + r; l++) {
                            for (int m = k; m < k + c; m++) {
                                if (map[l][m] && sticker[l - j][m - k]) {
                                    can = false;
                                }
                            }
                        }
                        if (can) {
                            hit = true;
                            for (int l = j; l < j + r; l++) {
                                for (int m = k; m < k + c; m++) {
                                    if (sticker[l - j][m - k]) map[l][m] = true;
                                }
                            }
                        }
                        if (hit) break;
                    }
                    if (hit) break;
                }
                if (!hit) {
                    sticker = spin(r, c, sticker);
                    int temp = r;
                    r = c;
                    c = temp;
                } else break;
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j]) ans++;
            }
        }
        System.out.println(ans);
    }

    static boolean[][] spin(int R, int C, boolean[][] map) {
        boolean[][] re = new boolean[C][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                re[j][R - 1 - i] = map[i][j];
            }
        }
        return re;
    }
}
