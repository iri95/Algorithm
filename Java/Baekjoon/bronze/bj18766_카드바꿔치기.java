package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj18766_카드바꿔치기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] before = new String[n];
            String[] after = new String[n];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                before[i] = st1.nextToken();
                after[i] = st2.nextToken();
            }
            Arrays.sort(before);
            Arrays.sort(after);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (!before[i].equals(after[i])) {
                    sb.append("CHEATER").append("\n");
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                sb.append("NOT CHEATER").append("\n");
            }
        }
        System.out.println(sb);
    }
}
