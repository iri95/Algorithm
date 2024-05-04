package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2118_두개의탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int lenSum = 0;
        int[] lens = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            int len = Integer.parseInt(br.readLine());
            lens[i] = lens[i - 1] + len;
            lenSum += len;
        }
        int ans = 0;
        /*
        시계 : lens[end] - lens[start]
        반시계 : lenSum - 시계
        만약 시계가 반시계보다 클 경우 : 시계방향을 줄여야 하므로 end - 1;
        시계가 더 클 경우 : start + 1;
         */
        for (int end = N; end > 0; end--) {
            int start = 0;
            while (true) {
                int right = lens[end] - lens[start];
                int left = lenSum - right;
                if (right >= left) {
                    ans = Math.max(ans, left);
                    start++;
                } else {
                    ans = Math.max(ans, right);
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
