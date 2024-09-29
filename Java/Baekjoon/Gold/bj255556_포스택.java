package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj255556_포스택 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (a < k) a = k;
            else if (b < k) b = k;
            else if (c < k) c = k;
            else if (d < k) d = k;
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
