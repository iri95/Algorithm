package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1711_직각삼각형 {
    static int N, result;
    static long[][] point;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        point = new long[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Long.parseLong(st.nextToken());
            point[i][1] = Long.parseLong(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    long l1 = (point[i][0] - point[j][0]) * (point[i][0] - point[j][0]) + (point[i][1] - point[j][1]) * (point[i][1] - point[j][1]);
                    long l2 = (point[j][0] - point[k][0]) * (point[j][0] - point[k][0]) + (point[j][1] - point[k][1]) * (point[j][1] - point[k][1]);
                    long l3 = (point[k][0] - point[i][0]) * (point[k][0] - point[i][0]) + (point[k][1] - point[i][1]) * (point[k][1] - point[i][1]);
                    if (l1 == l2 + l3 || l2 == l1 + l3 || l3 == l1 + l2) result++;
                }
            }
        }
        System.out.println(result);
    }
}
