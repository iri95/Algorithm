package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1009_분산처리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = a % 10;
            if (k == 0) {
                System.out.println(10);
                continue;
            }else if (k == 1 || k == 5 || k == 6) {
                System.out.println(k);
                continue;
            }
            if (k == 4 || k == 9) {
                int l = b % 2;
                if (l == 1) {
                    System.out.println(k);
                }else{
                    System.out.println((k * k)%10);
                }
                continue;
            }
            int l = b % 4;
            if (l == 0) {
                System.out.println((k * k * k * k)%10);
            }else{
                System.out.println((int)Math.pow(k, l)%10);
            }

        }
    }
}
