package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj4470_줄번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String str = br.readLine();
            System.out.println(i + ". " + str);
        }
    }
}
