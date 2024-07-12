package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1105_팔 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();
        if (L.length() != R.length()) System.out.println(0);
        else {
            int cnt = 0;
            for (int i = 0; i < L.length(); i++) {
                if (L.charAt(i) == '8' && R.charAt(i) == '8') cnt++;
                else if (L.charAt(i) != R.charAt(i)) break;
            }
            System.out.println(cnt);
        }
    }
}
