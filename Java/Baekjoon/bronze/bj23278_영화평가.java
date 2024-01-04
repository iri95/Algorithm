package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj23278_영화평가 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int sum = 0;
        for (int i = L; i < N - H; i++) {
            sum += list[i];
        }
        double avg = (double) sum / (N - H - L);
        System.out.printf(String.valueOf(avg));
    }
}
