package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1522_문자열교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int aSum = 0;
        for(int i = 0; i < N; i++){
            if (str.charAt(i) == 'a') aSum++;
        }
        int b = 0;
        int ans = N;
        for(int i = 0; i < aSum; i++){
            if (str.charAt(i) == 'b') b++;
        }
        ans = Math.min(b, ans);
        for(int i = aSum; i < N + aSum; i++){
            if (str.charAt(i % N) == 'a' ) {
                if (str.charAt(i - aSum) == 'b') b--;
            }else{
                if (str.charAt(i - aSum) == 'a') b++;
            }
            ans = Math.min(b, ans);
        }
        System.out.println(ans);
    }
}
