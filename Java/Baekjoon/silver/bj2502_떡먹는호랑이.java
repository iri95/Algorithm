package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2502_떡먹는호랑이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] xDp = new int[D + 1];
        int[] yDp = new int[D + 1];
        xDp[1] = 1;
        yDp[2] = 1;
        for (int i = 3; i < D + 1; i++) {
            xDp[i] = xDp[i - 1] + xDp[i - 2];
            yDp[i] = yDp[i - 1] + yDp[i - 2];
        }
        boolean end = false;
        for (int i = 1; i < 100001; i++) {
            for (int j = i; j < 100001; j++) {
                if(yDp[D] * j + xDp[D] * i > K)break;
                if (yDp[D] * j + xDp[D] * i == K) {
                    System.out.println(i);
                    System.out.println(j);
                    end = true;
                    break;
                }
            }
            if(end)break;
        }
    }
}
