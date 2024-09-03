package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15831_준표의조약돌 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        int s = 0, e = 0, b = 0, w = 0, ans = 0;
        if (arr[0] == 'B') b++;
        else w++;
        while (e < N) {
            if (b > B) {
                if (arr[s] == 'B') b--;
                else w--;
                s++;
            } else if (w < W) {
                if (++e >= N) break;
                if (arr[e] == 'B') b++;
                else w++;
            } else {
                ans = Math.max(e - s + 1, ans);
                if (++e >= N) break;
                if (arr[e] == 'B') b++;
                else w++;
            }
        }
        System.out.println(ans);
    }
}
