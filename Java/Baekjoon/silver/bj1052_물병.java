package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1052_물병 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (N <= K) {
            System.out.println(0);
            return;
        }
        String value = Integer.toBinaryString(N);
        int result = 0;
        while (oneCount(value) > K) {
            for (int i = value.length() - 1; i > 0; i--) {
                if (value.charAt(i) == '1') {
                    result += (int) Math.pow(2, value.length() - 1 - i);
                    int intValue = Integer.parseInt(value, 2);
                    intValue += (int) Math.pow(2, value.length() - 1 - i);
                    value = Integer.toBinaryString(intValue);
                    break;
                }
            }
        }
        System.out.println(result);
    }

    public static int oneCount(String str) {
        int cnt = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) == '1') cnt++;
        }
        return cnt;
    }
}
