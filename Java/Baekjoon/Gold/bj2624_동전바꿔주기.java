package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2624_동전바꿔주기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] count = new int[k + 1][T + 1];
        count[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            for (int j = T; j >= 0; j--) {
                for (int l = 0; l <= n; l++) {
                    if(j - (p * l) >= 0)count[i][j] += count[i - 1][j - (p * l)];
                }
            }
        }
        System.out.println(count[k][T]);
    }
}
