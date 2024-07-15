package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1311_할일정하기1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = 1 << N;
        int[][] arr = new int[N][N];
        int[] dp = new int[size]; // 일한 사람 조합별 최솟값.
        Arrays.fill(dp, 200_001);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        // https://www.acmicpc.net/source/66878118
        for (int i = 0; i < size; i++) {
            int onCnt = 0;
            // onCnt : 수행할 일
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    onCnt++;
                }
            }
            // j번 사람이 일을 onCnt번 일을 했을 때 최솟값
            // onCnt가 3일 경우 0~2번 일은 이미 수행한 상태임. -> i 반복문의 순서 떄문.
            // i가 101일 경우 0, 2번 사람이 일을 한 경우
            // 101은 i = 1일 때 2번 사람이 1번일을 한 경우, i = 100일 때 0번 사람이 1번일을 할 경우의 최솟값임.
            // 여기서 111, 1101, 10101, 100101....이런 식으로 최솟값을 채워나감
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) == 0) {
                    int n = i | (1 << j);
                    dp[n] = Math.min(dp[i] + arr[j][onCnt], dp[n]);
                }
            }
        }
        System.out.println(dp[size - 1]);
    }
}
