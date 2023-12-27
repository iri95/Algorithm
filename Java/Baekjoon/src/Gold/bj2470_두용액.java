package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2470_두용액 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int s = 0;
        int e = N - 1;
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        while (s < e) {
            int sum = list[s] + list[e];
            if (sum < 0) {
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    result = new int[]{list[s], list[e]};
                }
                s++;
            } else if (sum > 0) {
                if (min > sum) {
                    min = sum;
                    result = new int[]{list[s], list[e]};
                }
                e--;
            } else {
                result = new int[]{list[s], list[e]};
                break;
            }
        }
        System.out.println(result[0] + " " + result[1]);

    }
}
