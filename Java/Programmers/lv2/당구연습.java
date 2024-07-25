package lv2;

public class 당구연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int N = balls.length;
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;

            int nx = startX * (-1);
            if (startY != balls[i][1] || startX <= balls[i][0])
                min = Math.min((int) Math.pow(nx - balls[i][0], 2) + (int) Math.pow(startY - balls[i][1], 2), min);

            int ny = startY * (-1);
            if (startX != balls[i][0] || startY <= balls[i][1])
                min = Math.min((int) Math.pow(startX - balls[i][0], 2) + (int) Math.pow(ny - balls[i][1], 2), min);

            if (startX != balls[i][0] || startY >= balls[i][1]) {
                ny = 2 * n - startY;
                min = Math.min((int) Math.pow(startX - balls[i][0], 2) + (int) Math.pow(ny - balls[i][1], 2), min);
            }

            if (startY != balls[i][1] || startX >= balls[i][0]) {
                nx = 2 * m - startX;
                min = Math.min((int) Math.pow(nx - balls[i][0], 2) + (int) Math.pow(startY - balls[i][1], 2), min);
            }

            answer[i] = min;
        }
        return answer;
    }
}
