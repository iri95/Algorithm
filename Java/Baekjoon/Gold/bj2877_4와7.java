package Gold;

import java.io.*;

public class bj2877_4와7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int len = 1;
        int kLen = K;

        while (Math.pow(2, len) < kLen) {
            kLen -= (int) Math.pow(2, len);
            len++;
        }

        for (int i = len - 1; i >= 0; i--) {
            int value = (int) Math.pow(2, i);
            if (kLen > value) {
                sb.append(7);
                kLen -= value;
            } else sb.append(4);
        }

        System.out.println(sb);
    }
}
