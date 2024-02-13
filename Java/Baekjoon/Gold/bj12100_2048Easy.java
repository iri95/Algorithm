package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12100_2048Easy {
    static int N, ans;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(map, 0);
        System.out.println(ans);
    }

    // d 0, 1, 2, 3 -> 북 동 남 서
    // 이동할 수 있는지
    static void move(int d, int[][] temp) {
        switch (d) {
            case 0:
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        if (temp[j][i] != 0) {
                            int k = j;
                            while (true) {
                                if (k == 0 || temp[k - 1][i] != 0) break;
                                temp[k - 1][i] = temp[k][i];
                                temp[k][i] = 0;
                                k--;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < N; i++) {
                    for (int j = N - 2; j >= 0; j--) {
                        if (temp[i][j] != 0) {
                            int k = j;
                            while (true) {
                                if (k == N - 1 || temp[i][k + 1] != 0) break;
                                temp[i][k + 1] = temp[i][k];
                                temp[i][k] = 0;
                                k++;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    for (int j = N - 2; j >= 0; j--) {
                        if (temp[j][i] != 0) {
                            int k = j;
                            while (true) {
                                if (k == N - 1 || temp[k + 1][i] != 0) break;
                                temp[k + 1][i] = temp[k][i];
                                temp[k][i] = 0;
                                k++;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        if (temp[i][j] != 0) {
                            int k = j;
                            while (true) {
                                if (k == 0 || temp[i][k - 1] != 0) break;
                                temp[i][k - 1] = temp[i][k];
                                temp[i][k] = 0;
                                k--;
                            }
                        }
                    }
                }
                break;
        }
    }

    static void dfs(int[][] temp, int count) {
        if (count >= 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (temp[i][j] > ans) ans = temp[i][j];
                }
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] t = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    t[j][k] = temp[j][k];
                }
            }
            dfs(sum(i, t), count + 1);
        }
    }

    static int[][] sum(int d, int[][] temp) {
        move(d, temp);
        switch (d) {
            case 0:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - 1; j++) {
                        if (temp[j][i] == temp[j + 1][i]) {
                            temp[j][i] *= 2;
                            temp[j + 1][i] = 0;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j > 0; j--) {
                        if (temp[i][j] == temp[i][j - 1]) {
                            temp[i][j] *= 2;
                            temp[i][j - 1] = 0;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j > 0; j--) {
                        if (temp[j][i] == temp[j - 1][i]) {
                            temp[j][i] *= 2;
                            temp[j - 1][i] = 0;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - 1; j++) {
                        if (temp[i][j] == temp[i][j + 1]) {
                            temp[i][j] *= 2;
                            temp[i][j + 1] = 0;
                        }
                    }
                }
                break;
        }
        move(d, temp);
        return temp;
    }
}
