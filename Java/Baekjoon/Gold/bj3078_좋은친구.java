package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// TODO: Sliding Window 정리
public class bj3078_좋은친구 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[] list = new String[N];
        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }
        int[] count = new int[21];
        long answer = 0;
        for (int i = 0; i <= K; i++) {
            if (count[list[i].length()] > 0) {
                answer += count[list[i].length()];
            }
            count[list[i].length()]++;
        }
        for (int i = K + 1; i < N; i++) {
            count[list[i - K - 1].length()]--;
            if (count[list[i].length()] > 0) {
                answer += count[list[i].length()];
            }
            count[list[i].length()]++;
        }
        System.out.println(answer);
    }
}
