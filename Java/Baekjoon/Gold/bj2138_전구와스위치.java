package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://koguri.tistory.com/57 String으로 하면 메모리 초과가 일어남
public class bj2138_전구와스위치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = -1;
        int N = Integer.parseInt(br.readLine());
        StringBuilder value1 = new StringBuilder(br.readLine());
        StringBuilder value2 = new StringBuilder(value1);
        StringBuilder end = new StringBuilder(br.readLine());
        int cnt1 = 0;
        int cnt2 = 1;
        value2.setCharAt(0, value1.charAt(0) == '1' ? '0' : '1');
        value2.setCharAt(1, value1.charAt(1) == '1' ? '0' : '1');

        if (value1.compareTo(end) == 0) {
            System.out.println(0);
            return;
        }
        if (value2.compareTo(end) == 0) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i < N; i++) {
            if (value1.charAt(i - 1) != end.charAt(i - 1)) {
                if (i == N - 1) {
                    value1.setCharAt(i - 1, value1.charAt(i - 1) == '1' ? '0' : '1');
                    value1.setCharAt(i, value1.charAt(i) == '1' ? '0' : '1');
                }else {
                    value1.setCharAt(i-1,  value1.charAt(i-1) == '1' ? '0' : '1');
                    value1.setCharAt(i,  value1.charAt(i) == '1' ? '0' : '1');
                    value1.setCharAt(i+1,  value1.charAt(i+1) == '1' ? '0' : '1');
                }
                cnt1++;
            }
            if(value2.charAt(i-1) != end.charAt(i-1)) {
                if(i==N-1) {
                    value2.setCharAt(i-1,  value2.charAt(i-1) == '1' ? '0' : '1');
                    value2.setCharAt(i,  value2.charAt(i) == '1' ? '0' : '1');
                } else {
                    value2.setCharAt(i-1,  value2.charAt(i-1) == '1' ? '0' : '1');
                    value2.setCharAt(i,  value2.charAt(i) == '1' ? '0' : '1');
                    value2.setCharAt(i+1,  value2.charAt(i+1) == '1' ? '0' : '1');
                }
                cnt2++;
            }
        }
        if(!(value1.compareTo(end) == 0)) cnt1 = Integer.MAX_VALUE;
        if(!(value2.compareTo(end) == 0)) cnt2 = Integer.MAX_VALUE;
        int answer = Math.min(cnt1, cnt2);
        if(answer == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }

    }
}
