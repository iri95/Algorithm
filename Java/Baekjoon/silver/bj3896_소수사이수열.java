package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj3896_소수사이수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = 1299709;
        boolean[] visit = new boolean[len + 1];
        visit[0] = visit[1] = true;
        List<Integer> list = new ArrayList<>();
        for (long i = 2; i <= len; i++) {
            if (!visit[(int)i]) {
                list.add((int)i);
                for (long j = i * i; j <= len; j += i) {
                    visit[(int)j] = true;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int index = Collections.binarySearch(list, k);
            if (index >= 0) sb.append(0).append("\n");
            else {
                index = index * (-1) - 1;
                sb.append(list.get(index) - list.get(index - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
