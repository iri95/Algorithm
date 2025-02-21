package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1456_거의소수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int sqrt = (int) Math.sqrt(B);
        boolean[] notPrime = new boolean[sqrt + 1];
        long count = 0;
        for (int i = 2; i <= sqrt; i++) {
            if (notPrime[i]) continue;

            // int의 범위가 넘어갔을 때 -가 되어버려서 반복문 실행이 되는 걸 막기 위해 long으로 변환.
            for (long j = (long) i * i; j <= sqrt; j += i)
                notPrime[(int) j] = true;

            // long의 범위가 넘어가는 경우를 고려해 B / i, A / i를 해준다.
            for (long j = i; j <= B / i; j *= i)
                if ((double) A / i <= j)
                    count++;

        }
        System.out.println(count);
    }
}
