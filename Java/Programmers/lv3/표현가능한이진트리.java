package lv3;

import java.util.*;

// 1의 부모가 0이면 안된다.
// 1(1), 2(2 ~ 7), 3(8 ~ 255)....
// 2^1 - 1, 2^3 - 1, 2^7 - 1, 2^15 - 1, 2^31 - 1, 2^63 - 1;
public class 표현가능한이진트리 {
    public int[] solution(long[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int len = findLength(numbers[i]);
            answer[i] = sol(numbers[i], len) ? 1 : 0;
        }

        return answer;
    }

    private static int findLength(long n) {
        int pow = 0;
        for (int i = 0; i <= 5; i++) {
            pow += Math.pow(2, i);
            if (n <= (long) Math.pow(2, pow) - 1) {
                return pow;
            }
        }

        return 5;
    }

    private static boolean sol(long n, int len) {
        StringBuilder sb = new StringBuilder(Long.toBinaryString(n));
        while (sb.length() < len) {
            sb.insert(0, "0");
        }
        int mid = len / 2;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{mid, sb.charAt(mid) - '0'});
        // 1 -> 0, 3 -> 1, 7 -> 2, 15 -> 4, 31 -> 8, 63 -> 16 == len + 1 / 4
        int next = (len + 1) / 4;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int left = cur[0] - next;
                int right = cur[0] + next;
                if (cur[1] == 0) {
                    if (sb.charAt(left) - '0' == 1 || sb.charAt(right) - '0' == 1)
                        return false;
                }
                q.add(new int[]{left, sb.charAt(left) - '0'});
                q.add(new int[]{right, sb.charAt(right) - '0'});
            }
            next /= 2;
            if (next == 0) break;
        }

        return true;
    }
}
