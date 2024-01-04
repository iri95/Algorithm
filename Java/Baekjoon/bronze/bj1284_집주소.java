package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1284_집주소 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String N = br.readLine();
            if(N.equals("0"))return;
            int k = N.length() + 1;
            for (int i = 0; i < N.length(); i++) {
                int n = Character.getNumericValue(N.charAt(i));
                if (n == 1) {
                    k += 2;
                } else if (n == 0) {
                    k += 4;
                }else{
                    k += 3;
                }
            }
            System.out.println(k);
        }
    }
}
