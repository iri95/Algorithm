package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bj14928_큰수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        long ans = 0;
        for (int i = 0; i < n.length(); i++) {
            ans = (ans * 10 + (n.charAt(i) - '0')) % 20000303;
        }
        System.out.println(ans);
    }
}
