package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class bj2981_검문 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int gcd = arr[1] - arr[0];
        for (int i = 2; i < N; i++) gcd = GCD(gcd, arr[i] - arr[i - 1]);

        List<Integer> answer = new ArrayList<>();
        answer.add(gcd);
        for (int i = 2; i <= Math.sqrt(gcd); i++) {
            if (i * i == gcd) answer.add(i);
            else if (gcd % i == 0) {
                answer.add(i);
                answer.add(gcd / i);
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        if (answer.isEmpty()) sb.append((arr[0] + arr[1]) / 2 - 1);
        else
            for (int cur : answer) sb.append(cur).append(" ");
        System.out.println(sb);

    }

    private static int GCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
