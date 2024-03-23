package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class bj1393_음하철도구구팔 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xs = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int xe = Integer.parseInt(st.nextToken());
        int ye = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());
        int y = ye;
        int x = xe;
        int gcd = new BigInteger(String.valueOf(dy)).gcd(new BigInteger(String.valueOf(dx))).intValue();
        dy /= gcd;
        dx /= gcd;
        double len = 400;
        while (true) {
            if (Math.pow(Math.pow(ye - ys, 2) + Math.pow(xe - xs, 2), 0.5) < len) {
                len = Math.pow(Math.pow(ye - ys, 2) + Math.pow(xe - xs, 2), 0.5);
                y = ye;
                x = xe;
            }
            ye += dy;
            xe += dx;
            if(xe < -100 && ye < -100 || xe > 100 || ye > 100) break;
        }
        System.out.println(x + " " + y);
    }
}
