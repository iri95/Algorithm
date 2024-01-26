package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj2841_외계인의기타연주 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        Stack<Integer>[] stacks = new Stack[7];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (stacks[a] == null) stacks[a] = new Stack<>();
            if (stacks[a].isEmpty()) {
                cnt++;
                stacks[a].push(b);
                continue;
            }
            int peek = stacks[a].peek();
            while (peek > b) {
                cnt++;
                stacks[a].pop();
                peek = stacks[a].isEmpty() ? 0 : stacks[a].peek();
            }
            if (peek == b) continue;
            stacks[a].push(b);
            cnt++;
        }
        System.out.println(cnt);
    }
}
