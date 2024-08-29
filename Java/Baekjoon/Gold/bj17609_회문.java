package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj17609_회문 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            sb.append(isPal(str, 0, str.length()-1, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int isPal(String str, int s, int e, int cnt) {
        while (s < e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                if (cnt != 0) return 2;
                cnt++;
                int t = isPal(str, s, e - 1, cnt);
                if (t == 1) e--;
                else{
                    t = isPal(str, s + 1, e, cnt);
                    if (t == 1) s++;
                }
            }
        }
        return cnt;
    }

}
