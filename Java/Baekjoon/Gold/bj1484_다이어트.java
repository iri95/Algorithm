package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1484_다이어트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = (int) Math.sqrt(n); n >= Math.pow(i, 2) - Math.pow(i - 1, 2); i++) {
            int value = (int) Math.sqrt(Math.pow(i, 2) - n);
            if (value == 0) continue;
            if ((int) (Math.pow(i, 2) - Math.pow(value, 2)) == n) sb.append(i).append("\n");
        }
        if (sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);
    }
}
