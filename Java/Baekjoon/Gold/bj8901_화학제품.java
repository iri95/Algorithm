package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj8901_화학제품 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int AB = Integer.parseInt(st.nextToken());
            int BC = Integer.parseInt(st.nextToken());
            int CA = Integer.parseInt(st.nextToken());
            int k = Math.min(A, B);
            for (int i = k; i >= 0; i--) { // AB의 개수
                int bc, ca;
                if (BC > CA) {
                    bc = Math.min(B - i, C);
                    ca = Math.min(A - i, C - bc);
                }else{
                    ca = Math.min(A - i, C);
                    bc = Math.min(B - i, C - ca);
                }
                max = Math.max(max, i * AB + bc * BC + ca * CA);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
