package lv2;

public class 프랜즈4블록 {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        boolean[][] delete;
        boolean end = false;
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        while(true){
            end = false;
            delete = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    if (c == '.') continue;
                    if (map[i][j + 1] == c && map[i + 1][j] == c && map[i + 1][j + 1] == c) {
                        delete[i][j] = delete[i + 1][j] = delete[i][j + 1] = delete[i + 1][j + 1] = true;
                        end = true;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (delete[i][j]) map[i][j] = '.';
                }
            }
            if (!end) break;
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '.') continue;
                    int high = i;
                    while (high < m - 1) {
                        if (map[high + 1][j] == '.' ) {
                            map[high + 1][j] = map[high][j];
                            map[high][j] = '.';
                        } else break;
                        high++;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.') answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"})); // 14
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"})); // 15

    }
}
