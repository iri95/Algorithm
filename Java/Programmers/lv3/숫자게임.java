package lv3;

import java.util.Arrays;

public class 숫자게임 {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int indexA = 0;
        int indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] < B[indexB]) {
                answer++;
                indexA++;
                indexB++;
            }else{
                indexB++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}));
        System.out.println(solution(new int[]{2,2,2,2}, new int[]{1,1,1,1}));
    }
}
