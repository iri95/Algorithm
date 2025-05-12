package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1701_Cubeditor {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;

        for (int i = 0; i < str.length(); i++)
            answer = Math.max(answer, kmp(str.substring(i)));

        System.out.println(answer);
    }
    private static int kmp(String str){
        int[] table = new int[str.length()];
        int idx = 0;
        int value = 0;
        for(int i = 1; i < str.length(); i++){
            while(idx > 0 && str.charAt(i) != str.charAt(idx))
                idx = table[idx - 1];

            if (str.charAt(i) == str.charAt(idx))
                table[i] = ++idx;

            value = Math.max(idx, value);
        }

        return value;
    }
}
