package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2742_기찍N {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = N; i > 0; i--)
            sb.append(i).append("\n");
        System.out.println(sb);
    }
}
