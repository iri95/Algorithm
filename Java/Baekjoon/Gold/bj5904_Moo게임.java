package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj5904_Moo게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int k = 3;
        int index = 4;
        while (k <= 1_073_741_793) {
            list.add(k);
            k = k * 2 + index;
            index++;
        }
        while (true) {
            int i = Collections.binarySearch(list, N);
            if (i >= 0) {
                System.out.println("o");
                return;
            }
            i = (i + 1) * (-1);
            if (i == 0) {
                if (N == 1) {
                    System.out.println("m");
                    return;
                }else{
                    System.out.println("o");
                    return;
                }
            }
            int s = list.get(i - 1);
            if (N - s <= i + 3) {
                if (N - s == 1) {
                    System.out.println("m");
                    return;
                }else{
                    System.out.println("o");
                    return;
                }
            }else{
                N = N - s - i - 3;
            }
        }
    }
}
