package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1016_제곱ㄴㄴ수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] squared = new boolean[(int) (max - min + 1)];

        int answer = (int) (max - min + 1);
        for (long i = 2; i <= Math.sqrt(max); i++) {
            long pow = (long) Math.pow(i, 2);
            for (long j = min % pow == 0 ? min / pow * pow : min / pow * pow + pow; j <= max; j += pow) {
                if (!squared[(int) (j - min)]) {
                    answer--;
                    squared[(int) (j - min)] = true;
                }
            }
        }

        System.out.println(answer);
    }
}
