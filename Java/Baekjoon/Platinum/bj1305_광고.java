package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1305_광고 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] table = new int[N];
        int idx = 0;
        for(int i = 1; i < N; i++){
            while(idx > 0 && str.charAt(i) != str.charAt(idx))
                idx = table[idx - 1];

            if (str.charAt(i) == str.charAt(idx))
                table[i] = ++idx;
        }
        System.out.println(N - table[N - 1]);
    }
}
