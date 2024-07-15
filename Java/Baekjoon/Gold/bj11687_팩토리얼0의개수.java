package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11687_팩토리얼0의개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int index = 0;
        while (M > 0) {
            index += 5;
            int k = index;
            while (k % 5 == 0) {
                M--;
                k /= 5;
            }
        }
        if (M < 0) System.out.println(-1);
        else System.out.println(index);
    }
}
