package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj3015_오아시스재결합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<long[]> stack = new ArrayDeque<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            long cnt = 0;
            long same = 0;
            while (!stack.isEmpty()) {
                long[] peek = stack.peekFirst();
                cnt++;
                if (peek[0] > n) break;
                else if (peek[0] < n) {
                    long[] pop = stack.pop();
                    cnt += pop[1];
                }
                else {
                    long[] pop = stack.pop();
                    same = pop[1] + 1;
                    cnt += pop[1];
                }
            }
            answer += cnt;
            stack.push(new long[] {n, same});
        }
        System.out.println(answer);
    }
}
