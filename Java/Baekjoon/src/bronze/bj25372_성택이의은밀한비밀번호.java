package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj25372_성택이의은밀한비밀번호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            if (str.length() >= 6 && str.length() <= 9) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
