package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj9086_문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            sb.append(str.charAt(0)).append(str.charAt(str.length() - 1)).append("\n");
        }
        System.out.println(sb);
    }
}
