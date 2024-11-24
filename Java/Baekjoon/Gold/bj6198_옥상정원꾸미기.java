package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj6198_옥상정원꾸미기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long[] cnt = new long[N];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        stack.push(N - 1);
        long sum = 0;
        for (int i = N - 2; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (arr[i] <= arr[stack.peekFirst()]) break;
                int a = stack.pop();
                cnt[i] += cnt[a] + 1;
            }
            sum += cnt[i];
            stack.push(i);
        }
        System.out.println(sum);
    }
}
