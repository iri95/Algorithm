package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj4716_풍선 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (N == 0 && A == 0 && B == 0) break;
            int[][] teams = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                teams[i][0] = Integer.parseInt(st.nextToken());
                teams[i][1] = Integer.parseInt(st.nextToken());
                teams[i][2] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            Arrays.sort(teams, Comparator.comparingInt(o -> (o[1] - o[2])));
            for (int i = 0; i < N; i++) {
                if (teams[i][2] - teams[i][1] < 0) break;
                if (A >= teams[i][0]) {
                    A -= teams[i][0];
                    ans += teams[i][1] * teams[i][0];
                    teams[i][0] = 0;
                } else {
                    ans += teams[i][1] * A;
                    teams[i][0] -= A;
                    A = 0;
                }
                if (A == 0) break;
            }
            for (int i = N - 1; i >= 0; i--) {
                if (teams[i][1] - teams[i][2] < 0) break;
                if (B >= teams[i][0]) {
                    B -= teams[i][0];
                    ans += teams[i][2] * teams[i][0];
                    teams[i][0] = 0;
                } else {
                    ans += teams[i][2] * B;
                    teams[i][0] -= B;
                    B = 0;
                }
                if (B == 0) break;
            }
            Arrays.sort(teams, Comparator.comparingInt(o -> o[0]));
            for (int i = N - 1; i >= 0; i--) {
                if (teams[i][0] == 0) break;
                if (A == 0) ans += teams[i][0] * teams[i][2];
                else if (B == 0) ans += teams[i][0] * teams[i][1];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
