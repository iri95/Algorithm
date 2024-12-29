package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1011_FlymetotheAlphaCentauri {
    /*
    1 1 1
    2 2 11
    3 4 121
    4 6 1221
    5 9 12321
    6 12 123321
    7 16
    8 20
    9 25
    10 30
    11 36
    12 42
    13 49
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int len = y - x;
            int max = (int) Math.sqrt(len);
            int ans = 2 * max;
            int pow = (int) Math.pow(max, 2);
            if (pow == len) ans--;
            else if (pow + max < len) ans++;
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
