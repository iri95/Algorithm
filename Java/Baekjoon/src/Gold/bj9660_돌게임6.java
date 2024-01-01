package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9660_돌게임6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n % 7 != 2 && n % 7 != 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
