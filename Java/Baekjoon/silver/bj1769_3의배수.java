package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj1769_3의배수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        long k = 0;
        if(str.length() == 1)k  = Long.parseLong(str);
        while (str.length() != 1) {
            k = 0;
            cnt++;
            for (int i = 0; i < str.length(); i++) {
                k += Character.getNumericValue(str.charAt(i));
            }
            str = String.valueOf(k);
        }
        System.out.println(cnt);
        if(k % 3 != 0) System.out.println("NO");
        else System.out.println("YES");
    }
}
