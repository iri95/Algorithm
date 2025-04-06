package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj15678_연세워터파크 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        long[] dp = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        long answer = -1_000_000_001;
        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - D) deque.pollFirst();
            if (!deque.isEmpty()) dp[i] = Math.max(dp[i], dp[deque.peekFirst()] + dp[i]);
            while (!deque.isEmpty() && dp[deque.peekLast()] < dp[i]) deque.pollLast();
            if (dp[i] > 0) deque.addLast(i);
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
