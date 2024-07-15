package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11687_팩토리얼0의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int cnt = 0;
        int index = 0;
        while (cnt < M) {
            index++;
            int k = index * 5;
            while (k % 5 == 0) {
                cnt++;
                k /= 5;
            }
        }
        if (cnt > M) System.out.println(-1);
        else System.out.println(index * 5);
    }
}
