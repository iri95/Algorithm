package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1120_문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int min = 51;
        int cnt = 0;
        for (int i = 0; i < b.length() - a.length() + 1; i++) {
            cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i + j)) {
                    cnt++;
                }
            }
            min = Math.min(cnt, min);
        }
        System.out.println(min);
    }
}
