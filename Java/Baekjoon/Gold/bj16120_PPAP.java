package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj16120_PPAP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.equals("P")) {
            System.out.println("PPAP");
            return;
        } else if (str.length() < 4) {
            System.out.println("NP");
            return;
        }
        int p = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'P') p++;
            else {
                if (p < 2 || str.charAt(i + 1) != 'P') {
                    System.out.println("NP");
                    return;
                }
                p-= 2;
            }
        }
        p++;
        if (p != 1)  System.out.println("NP");
        else System.out.println("PPAP");
    }
}
