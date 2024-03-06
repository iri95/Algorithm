package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1300_K번째수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int min = 1;
        int max = K;
        while (min < max) {
            int mid = (min + max) / 2;
            int cnt = 0;
            // 2차원 배열에서 mid 이하인 값들의 개수를 더함.
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
            // mid 이하의 개수가 K 보다 크거나 같을 때
            if (cnt >= K)
                max = mid;
            else // mid 이하의 개수가 K보다 작을 떄
                min = mid + 1;
        }
        // 결국 max와 min이 값이 같아져야 while문이 끝나기 때문에 max, min 두다 넣어도 답이 됨.
        System.out.println(max);
    }
}
