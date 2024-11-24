package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class bj6198_옥상정원꾸미기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long[] cnt = new long[N];
        Deque<long[]> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        stack.push(new long[]{arr[N - 1], 0});
        long sum = 0;
        for (int i = N - 2; i >= 0; i--) {
            while(!stack.isEmpty()){
                if (arr[i] <= stack.peekFirst()[0]) break;
                long[] a = stack.pop();
                cnt[i] += a[1] + 1;
            }
            sum += cnt[i];
            stack.push(new long[] {arr[i], cnt[i]});
        }
        System.out.println(sum);
    }
}
