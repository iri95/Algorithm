package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2744_대소문자바꾸기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String LowA = a.toLowerCase();
        String UpA = a.toUpperCase();
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= 65 && a.charAt(i) <= 90) {
                result += LowA.charAt(i);
            }else {
                result += UpA.charAt(i);
            }
        }
        System.out.println(result);

    }
}
