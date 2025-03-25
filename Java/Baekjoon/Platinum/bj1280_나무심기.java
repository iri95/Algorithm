package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1280_나무심기 {
    static int INF = 1_000_000_007, last = 200_001;
    static long[] fenwickSum = new long[200_002], fenwickCnt = new long[200_002];
    ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 1;
        int index = Integer.parseInt(br.readLine()) + 1;

        update(fenwickSum, index, index);
        update(fenwickCnt, index, 1);

        for (int i = 1; i < N; i++) {
            index = Integer.parseInt(br.readLine()) + 1;

            long leftSum = sum(fenwickSum, index - 1);
            long leftCnt = sum(fenwickCnt, index - 1);

            long rightSum = sum(fenwickSum, last) - sum(fenwickSum, index);
            long rightCnt = sum(fenwickCnt, last) - sum(fenwickCnt, index);

            long sum = 0;
            if (leftCnt != 0) sum += (index * leftCnt - leftSum) % INF;
            if (rightCnt != 0) sum += (rightSum - index * rightCnt) % INF;
            result *= sum;
            result %= INF;
            update(fenwickSum, index, index);
            update(fenwickCnt, index, 1);
        }

        System.out.println(result);
    }

    private static void update(long[] fenwickTree, int index, int value) {
        for (int i = index; i <= last; i += (i & -i)) {
            fenwickTree[i] += value;
        }
    }

    private static long sum(long[] fenwickTree, int index) {
        long sum = 0;
        for (int i = index; i > 0; i -= (i & -i)) {
            sum += fenwickTree[i];
        }
        return sum;
    }
}
