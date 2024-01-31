package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20207_달력 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[366];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end + 1; j++) {
                cnt[j]++;
            }
        }
        int width = 0;
        int high = 0;
        int sum = 0;
        for (int i = 1; i < 366; i++) {
            if (cnt[i] == 0) {
                sum += high * width;
                high = width = 0;
                continue;
            }
            width++;
            high = Math.max(high, cnt[i]);
        }
        sum += high * width;
        System.out.println(sum);
    }
}
