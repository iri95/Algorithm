package lv4;

public class 쿠키구입 {
    static int N;
    static int[] sum;

    public int solution(int[] cookie) {
        int answer = 0;
        N = cookie.length;
        sum = new int[N + 1];
        for (int i = 1; i <= N; i++)
            sum[i] = sum[i - 1] + cookie[i - 1];

        for (int i = 0; i < N - 1; i++) {
            int l = i + 1;
            int r = i + 2;
            while (r <= N) {
                int left = sum[l] - sum[i];
                int right = sum[r] - sum[l];
                if (left == right) {
                    answer = Math.max(answer, left);
                    l++;
                    r++;
                } else if (left < right) l++;
                else r++;
            }
        }

        return answer;
    }
}