package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class bj6503_망가진키보드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            char[] str = br.readLine().toCharArray();
            int s = 0, e = 0, len = 0, max = 0;
            int[] count = new int[128];
            while (e < str.length) {
                while (len <= N && e < str.length) {
                    if (count[str[e]] == 0) {
                        if (len == N) break;
                        len++;
                    }
                    count[str[e]]++;
                    e++;
                }
                max = Math.max(e - s, max);
                while (true) {
                    count[str[s]]--;
                    if (count[str[s++]] == 0) {
                        len--;
                        break;
                    }
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
