package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj3015_오아시스재결합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<int[]> stack = new ArrayDeque<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            int same = 1;
            while (!stack.isEmpty() && stack.peekFirst()[0] <= n) {
                int[] pop = stack.pop();
                cnt += pop[1];
                if (pop[0] == n) same = pop[1] + 1;
            }
            cnt += !stack.isEmpty() ? 1 : 0;
            answer += cnt;
            stack.push(new int[]{n, same});
        }
        System.out.println(answer);
    }
}
