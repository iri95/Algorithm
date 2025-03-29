package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11689_GCD {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long answer = N;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0){
                answer -= answer / i;
                while(N % i == 0) N /= i;
            }
        }
        if (N > 1) answer -= answer / N;
        System.out.println(answer);
    }
}
