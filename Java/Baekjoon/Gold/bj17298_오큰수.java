package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17298_오큰수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && list[i] > list[stack.peek()]) {
                list[stack.pop()] = list[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            list[stack.pop()] = -1;
        }
        for (int a :list
             ) {
            sb.append(a + " ");
        }
        System.out.println(sb);
    }
}
