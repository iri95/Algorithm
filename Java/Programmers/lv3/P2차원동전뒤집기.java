package lv3;
// 최솟값 : 같은 열, 행을 2번 뒤집을 필요는 없다.
// 1행을 뒤집은 경우, 뒤집지 않은 경우 -> 1행의 모든 열을 target과 맞춰 준다. -> 나머지

public class P2차원동전뒤집기 {
    static int row, col;
    static int[][] a, b; // a : 1행을 뒤집지 않은 동전, b : 1행을 뒤집은 동전

    public int solution(int[][] beginning, int[][] target) {
        row = target.length;
        col = target[0].length;
        a = new int[row][col];
        b = new int[row][col];

        for (int i = 0; i < col; i++) {
            a[0][i] = beginning[0][i];
            b[0][i] = beginning[0][i] == 1 ? 0 : 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = beginning[i][j];
                b[i][j] = beginning[i][j];
            }
        }
        int aCnt = sol(a, target);
        int bCnt = sol(b, target);

        if (aCnt != -1 && bCnt != -1)
            return Math.min(aCnt, bCnt + 1);
        else if (aCnt != -1)
            return aCnt;
        else if (bCnt != -1)
            return bCnt + 1;
        else
            return -1;
    }

    private static int sol(int[][] board, int[][] target) {
        int count = 0;

        // 1행의 i열의 값을 비교해 다르다면 그 열의 뒤집어 준다.
        for (int i = 0; i < col; i++) {
            if (board[0][i] != target[0][i]) {
                count++;
                for (int j = 0; j < row; j++)
                    board[j][i] = board[j][i] == 1 ? 0 : 1;
            }
        }

        for (int i = 1; i < row; i++) {
            if (board[i][0] != target[i][0]) {
                count++;
                for (int j = 0; j < col; j++)
                    board[i][j] = board[i][j] == 1 ? 0 : 1;
            }
        }

        return judge(board, target) ? count : -1;
    }

    private static boolean judge(int[][] board, int[][] target) {

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (board[i][j] != target[i][j])
                    return false;

        return true;
    }
}
