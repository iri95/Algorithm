package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj15927_회문은회문이아니야 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean flag = true;
        int s = 0;
        int len = str.length();
        int e = len - 1;
        if (len == 1) {
            System.out.println(-1);
            return;
        }

        while(s <= e){
            if (str.charAt(s) != str.charAt(e)){
                System.out.println(len);
                return;
            }
            if (str.charAt(s) != str.charAt(s + 1)) flag = false;
            s++; e--;
        }

        if (flag) System.out.println(-1);
        else System.out.println(len - 1);
    }
}
