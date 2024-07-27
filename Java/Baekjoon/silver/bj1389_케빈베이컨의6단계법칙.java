package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1389_케빈베이컨의6단계법칙 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        int INF = 5001;
        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    int len = map[j][i] + map[i][k];
                    if (map[j][k] > len){
                        map[j][k] = len;
                    }
                }
            }
        }
        int num = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) sum += map[i][j];
            if (sum < INF){
                INF = sum;
                num = i;
            }
        }
        System.out.println(num);
    }
}
