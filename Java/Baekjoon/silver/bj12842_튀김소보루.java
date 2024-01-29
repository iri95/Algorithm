package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12842_튀김소보루 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int cnt = n - s;
        int m = Integer.parseInt(br.readLine());
        if (m >= cnt) {
            System.out.println(cnt);
            return;
        }
        cnt -= m;
        int[] time = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }
        int timeCount = 1;
        while (cnt > 0) {
            for (int i = 1; i <= m; i++) {
                if (timeCount % time[i] == 0) cnt--;
                if (cnt == 0) {
                    System.out.println(i);
                    return;
                }
            }
            timeCount++;
        }
    }
}
