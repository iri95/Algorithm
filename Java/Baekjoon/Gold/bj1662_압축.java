package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1662_압축 {
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = str.toCharArray();
        System.out.println(findLen(0, str.length()));
    }

    private static int findLen(int start, int end) {
        int answer = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] == '(') {
                int index = i + 1;
                int left = 1;
                int right = 0;
                while (true) {
                    if (arr[index] == '(') left++;
                    else if (arr[index] == ')') right++;
                    if (left == right) break;
                    index++;
                }
                answer += (arr[i - 1] - '0') * findLen(i + 1, index) - 1;
                i = index;
            } else answer++;
        }
        return answer;
    }
}
