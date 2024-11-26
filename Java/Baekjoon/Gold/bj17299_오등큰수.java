package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj17299_오등큰수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[1_000_001];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[N - 1]);

        int[] ans = new int[N];
        Arrays.fill(ans, -1);

        for (int i = N - 2; i >= 0; i--) {
            while(!stack.isEmpty()){
                int peek = stack.peekFirst();
                if (cnt[peek] > cnt[arr[i]]) break;
                stack.pop();
            }
            if (!stack.isEmpty()) ans[i] = stack.peekFirst();
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(ans[i]).append(" ");

        System.out.println(sb);
    }
}
