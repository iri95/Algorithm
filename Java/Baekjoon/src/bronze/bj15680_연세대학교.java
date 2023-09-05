package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj15680_연세대학교 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println("YONSEI");
        }else{
            System.out.println("Leading the Way to the Future");
        }
    }
}
