package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11758_CCW {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] p = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }
        int ccw = (p[0][0] * p[1][1] + p[1][0] * p[2][1] + p[2][0] * p[0][1]) - (p[0][1] * p[1][0] + p[1][1] * p[2][0] + p[2][1] * p[0][0]);
        if (ccw < 0) System.out.println(-1);
        else if (ccw == 0) System.out.println(0);
        else System.out.println(1);
    }
}
