package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9519_졸려 {
    static StringBuilder str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        str = new StringBuilder(br.readLine());
        StringBuilder str2 = new StringBuilder(str);
        int cnt = 0;
        while (X-- > 0) {
            cnt++;
            change();
            if (str2.compareTo(str) == 0) {
                X %= cnt;
            }
        }
        System.out.println(str);
    }

    static void change() {
        int L = str.length();
        for (int i = 1; i <= L / 2; i++) {
            str.insert(str.length() - i + 1, str.charAt(i));
            str.delete(i, i + 1);
        }
    }
}
