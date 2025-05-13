package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj4354_문자열제곱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if (str.equals(".")) break;
            int[] table = new int[str.length()];
            int idx = 0;
            int aLen = 1;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != str.charAt(idx)) {
                    if (table[i - 1] == 1)  aLen = i;
                    else aLen = i + 1;
                }

                while(idx > 0 && str.charAt(i) != str.charAt(idx))
                    idx = table[idx - 1];

                if (str.charAt(i) == str.charAt(idx))
                    table[i] = ++idx;
            }
            if (str.length() % aLen != 0) sb.append(1).append("\n");
            else sb.append(str.length() / aLen).append("\n");
        }

        System.out.println(sb);
    }
}
