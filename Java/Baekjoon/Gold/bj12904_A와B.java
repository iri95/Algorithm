package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class bj12904_A와B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        while (S.length() < T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            }else {
                T = T.substring(0, T.length() - 1);
                StringBuffer str = new StringBuffer(T);
                T = str.reverse().toString();
            }
        }
        if (S.equals(T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
