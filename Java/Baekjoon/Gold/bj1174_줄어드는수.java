package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj1174_줄어드는수 {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sol();
        int n = Integer.parseInt(br.readLine());
        if (n > list.size()) System.out.println(-1);
        else System.out.println(list.get(n - 1));
    }

    static void sol() {
        int index = 0;
        for (long i = 0; i < 10L; i++) {
            list.add(i);
        }
        for (int i = 1; i <= 10; i++) { // 9876543210
            int size = list.size();
            long p = (long) Math.pow(10, i - 1);
            for (long j = 1; j < 10; j++) {
                for (int k = index; k < size; k++) {
                    if (list.get(k) / p < j) list.add(list.get(k) + j * p * 10);
                }
            }
            index = size;
        }
    }
}
