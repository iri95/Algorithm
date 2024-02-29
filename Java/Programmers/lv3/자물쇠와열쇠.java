package lv3;

public class 자물쇠와열쇠 {
    public static boolean solution(int[][] key, int[][] lock) {
        int count1 = 0; // lock 홈의 개수
        int count2 = 0; // key 돌기의 개수
        int N = lock.length;
        int M = key.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) count1++;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (key[i][j] == 1) count2++;
            }
        }
        if (count1 == 0) return true;
        if (count1 > count2) return false;
        for (int y = -M + 1; y < N; y++) {
            for (int x = -M + 1; x < N; x++) {
                // 0
                boolean cant = false;
                int cnt = count1;
                for (int i = 0; i < M; i++) {
                    if (y + i >= N || y + i < 0) continue;
                    for (int j = 0; j < M; j++) {
                        if (x + j >= N || x + j < 0) continue;
                        if (key[i][j] == 1) {
                            if (lock[y + i][x + j] == 0) cnt--;
                            else {
                                cant = true;
                                break;
                            }
                        }
                    }
                    if (cant) break;
                }
                if (cnt == 0 && !cant) return true;

                // 90
                cnt = count1;
                cant = false;
                for (int i = 0; i < M; i++) {
                    if (y + i >= N || y + i < 0) continue;
                    for (int j = M - 1; j >= 0; j--) {
                        if (x + (M - j - 1) >= N || x + (M - j - 1) < 0) continue;
                        if (key[j][i] == 1) {
                            if (lock[y + i][x + (M - j - 1)] == 0) cnt--;
                            else {
                                cant = true;
                                break;
                            }
                        }
                    }
                    if (cant) break;
                }
                if (cnt == 0 && !cant) return true;

                // 180
                cant = false;
                cnt = count1;
                for (int i = M - 1; i >= 0; i--) {
                    if (y + (M - i - 1) >= N || y + (M - i - 1) < 0) continue;
                    for (int j = M - 1; j >= 0; j--) {
                        if (x + (M - j - 1) >= N || x + (M - j - 1) < 0) continue;
                        if (key[i][j] == 1) {
                            if (lock[y + (M - i - 1)][x + (M - j - 1)] == 0) cnt--;
                            else {
                                cant = true;
                                break;
                            }
                        }
                    }
                    if (cant) break;
                }
                if (cnt == 0 && !cant) return true;

                // 270
                cnt = count1;
                cant = false;
                for (int i = M - 1; i >= 0; i--) {
                    if (y + (M - i - 1) >= N || y + (M - i - 1) < 0) continue;
                    for (int j = 0; j < M; j++) {
                        if (x + j >= N || x + j < 0) continue;
                        if (key[j][i] == 1) {
                            if (lock[y + (M - i - 1)][x + j] == 0) cnt--;
                            else {
                                cant = true;
                                break;
                            }
                        }
                    }
                    if (cant) break;
                }
                if (cnt == 0 && !cant) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }
}
