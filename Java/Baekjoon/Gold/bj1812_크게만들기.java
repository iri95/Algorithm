package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj1812_크게만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        // 앞에서부터 뒤의 값과 비교해서 앞의 수가 더 작으면 삭제
        // stack에 넣어서 뒷자리 보다 큰 앞자리를 저장하다가 지워지면 다시 스택에서 꺼내서 비교할 앞 수를 가져옴
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        stack.push(str.charAt(0) - '0');
        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (K > cnt && index < N) {
            int num = str.charAt(index) - '0';
            int k = stack.pop();
            if (k >= num) {
                stack.push(k);
                stack.push(num);
                index++;
            } else {
                cnt++;
            }
            if (stack.isEmpty() || cnt == K) {
                stack.push(num);
                index++;
            }
        }
        int size = stack.size();
        int sbL = N - index;
        for (int i = 0; i < sbL + size - N + K; i++) {
            stack.pop();
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        sb.append(str.substring(index));
        System.out.println(sb);
    }
}
