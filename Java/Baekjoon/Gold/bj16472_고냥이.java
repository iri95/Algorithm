package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj16472_고냥이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        int[] count = new int[26];
        int cnt = 0;
        int first = 0;
        int answer = 0;
        for (int i = 0; i < len; i++) {
            int Char = str.charAt(i) - 'a';
            if (count[Char] > 0) count[Char]++;
            else {
                if (N <= cnt) {
                    while (cnt >= N) {
                        int index = str.charAt(first++) - 'a';
                        if (--count[index] == 0) cnt--;
                    }
                }
                count[Char]++;
                cnt++;
            }
            answer = Math.max(answer, i - first + 1);
        }
        System.out.println(answer);
    }
}
