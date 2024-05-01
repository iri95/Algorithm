package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://ilmiodiario.tistory.com/166
public class bj7490_0만들기 {
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sol(2, 1, 0, 1, new StringBuilder("1"));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void sol(int index, int num, int value, int op, StringBuilder str) {
        if (n < index) {
            value += num * op;
            if (value == 0) sb.append(str.toString()).append('\n');
            return;
        }
        sol(index + 1, num * 10 + index, value, op, str.append(' ').append(index));
        str.delete(str.length() - 2, str.length());
        sol(index + 1, index, value + num * op, 1, str.append('+').append(index));
        str.delete(str.length() - 2, str.length());
        sol(index + 1, index, value + num * op, -1, str.append('-').append(index));
        str.delete(str.length() - 2, str.length());
    }
}
