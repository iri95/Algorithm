package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj16936_나3곱2 {
    private static class Number implements Comparable<Number> {
        long number;
        int count3;

        Number(long n) {
            number = n;
            count3 = 0;
            while (n % 3 == 0) {
                count3++;
                n /= 3;
            }
        }

        public int compareTo(Number n) {
            if (this.count3 == n.count3) return Long.compare(this.number, n.number);
            else return n.count3 - this.count3;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Number[] arr = new Number[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = new Number(Long.parseLong(st.nextToken()));

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(arr[i].number).append(" ");
        System.out.println(sb);
    }
}