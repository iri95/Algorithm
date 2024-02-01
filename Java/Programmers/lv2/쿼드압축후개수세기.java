package lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 쿼드압축후개수세기 {
    public static int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        int k = arr[0].length;
        if (k == 1) {
            answer[arr[0][0]]++;
            return answer;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty() && k >= 1) {
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                if (can(arr, p, k)) answer[arr[p[0]][p[1]]]++;
                else {
                    queue.offer(p);
                    queue.offer(new int[]{p[0], p[1] + k / 2});
                    queue.offer(new int[]{p[0] + k / 2, p[1]});
                    queue.offer(new int[]{p[0] + k / 2, p[1] + k / 2});
                }
            }
            k /= 2;
        }
        return answer;
    }

    public static boolean can(int[][] arr, int[] p, int k) {
        int value = arr[p[0]][p[1]];
        for (int i = p[0]; i < p[0] + k; i++) {
            for (int j = p[1]; j < p[1] + k; j++) {
                if (arr[i][j] != value) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1}}))); // [4,9]
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1}, {1, 1}}))); // [4,9]
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}}))); // [4,9]
        System.out.println(Arrays.toString(solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}}))); // [10,15]
    }
}
