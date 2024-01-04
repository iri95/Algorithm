package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1094_막대기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int cnt = 1;
        int k = 64;
        int kx = 64;
        while (k != x) {
            kx /= 2;
            if (k - kx >= x) {
                k -= kx;
                continue;
            }
            cnt++;
        }
        System.out.println(cnt);

    }
}
