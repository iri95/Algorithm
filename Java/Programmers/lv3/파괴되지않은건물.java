package lv3;

public class 파괴되지않은건물 {
    public static int solution(int[][] board, int[][] skill) {
        int answer = board.length * board[0].length;
        int[][] sum = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < skill.length; i++) {
            if (skill[i][0] == 1) {
                sum[skill[i][1]][skill[i][2]] -= skill[i][5];
                sum[skill[i][3] + 1][skill[i][2]] += skill[i][5];
                sum[skill[i][1]][skill[i][4] + 1] += skill[i][5];
                sum[skill[i][3] + 1][skill[i][4] + 1] -= skill[i][5];
            } else {
                sum[skill[i][1]][skill[i][2]] += skill[i][5];
                sum[skill[i][3] + 1][skill[i][2]] -= skill[i][5];
                sum[skill[i][1]][skill[i][4] + 1] -= skill[i][5];
                sum[skill[i][3] + 1][skill[i][4] + 1] += skill[i][5];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                sum[i][j] = sum[i][j] + sum[i][j - 1];
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 1; j < board.length; j++) {
                sum[j][i] = sum[j - 1][i] + sum[j][i];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + sum[i][j] <= 0) answer--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
        System.out.println(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}}));

    }

}
