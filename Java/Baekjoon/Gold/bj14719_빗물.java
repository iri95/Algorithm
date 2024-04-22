package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] map = new int[W];
        int[] lMax = new int[W];
        int[] rMax = new int[W];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            lMax[i] = max;
            max = Math.max(max, map[i]);
        }
        max = 0;
        for (int i = W - 1; i >= 0; i--) {
            rMax[i] = max;
            max = Math.max(max, map[i]);
        }
        int ans = 0;
        for(int i = 1; i < W; i++){
            max = Math.min(lMax[i], rMax[i]);

            if(map[i] < max)
                ans += max - map[i];
        }

        System.out.println(ans);
    }
}
