package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1027_고층건물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] list = new long[N];
        for (int i = 0; i < N; i++) {
            list[i] = Long.parseLong(st.nextToken());
        }
        int[] count = new int[N];
        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            count[i]++;
            count[i + 1]++;
            double b = (double) (list[i + 1] - list[i]);
            for (int j = i + 2; j < N; j++) {
                double a = (double) (list[j] - list[i]) / (j - i);
                if (a > b) {
                    count[i]++;
                    count[j]++;
                    b = a;
                }
            }
            answer = Math.max(answer, count[i]);
        }
        answer = Math.max(answer, count[N - 1]);
        System.out.println(answer);
    }
}
