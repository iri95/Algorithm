package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1449_수리공항승 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boolean[] hall = new boolean[1001];
        for (int i = 0; i < N; i++) {
            hall[Integer.parseInt(st.nextToken())] = true;
        }
        int cnt = 0;
        for (int i = 1; i < 1001; i++) {
            if (hall[i]) {
                for (int j = i; j < i + L && j < 1001; j++) {
                    hall[j] = false;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
