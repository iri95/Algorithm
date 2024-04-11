package lv2;

public class 하노이의탑 {
    /*
    1 3 7 15 31 63 127 Math.pow(2, n) - 1
    */
    static int index = 0;
    public int[][] solution(int n) {
        int count = (int) Math.pow(2 , n) - 1;
        int[][] answer = new int[count][2];
        hanoi(answer, n, 1, 2, 3);


        return answer;
    }
    public static void hanoi(int[][] answer, int n, int from, int temp, int to){
        if(n == 0) return;
        hanoi(answer, n - 1, from, to, temp);
        answer[index++] = new int[]{from, to};
        hanoi(answer, n - 1, temp, from, to);
    }
}
