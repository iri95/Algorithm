package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9935_문자열폭발 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(str, 0, bomb.length() - 1);
        int index = 0;
        for (int i = bomb.length() - 1; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= bomb.length() && sb.substring(index, index + bomb.length()).equals(bomb)) {
                sb.delete(index, index + bomb.length());
                if (index >= bomb.length()) index -= bomb.length() - 1;
                else index = 0;
            } else if (sb.length() >= bomb.length()) index++;
        }
        if (sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb);
    }
}
