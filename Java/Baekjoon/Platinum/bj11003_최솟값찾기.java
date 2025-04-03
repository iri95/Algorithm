package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj11003_최솟값찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - L + 1)
                deque.pollFirst();

            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i])
                deque.pollLast();

            deque.addLast(i);
            sb.append(arr[deque.peekFirst()]).append(" ");
        }

        System.out.println(sb);
    }
}