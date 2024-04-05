package lv3;

import java.util.Arrays;

public class 합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int MAX_VALUE = 20_000_001;
        int answer = MAX_VALUE;
        int M = fares.length;
        int[][] distance = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(distance[i], MAX_VALUE);
            distance[i][i] = 0;
        }
        for(int[] k : fares){
            int c = k[0];
            int d = k[1];
            int f = k[2];
            distance[d][c] = f;
            distance[c][d] = f;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                for(int k = 1; k <= n; k++){
                    distance[j][k] = Math.min(distance[j][i] + distance[i][k], distance[j][k]);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            answer = Math.min(distance[s][i] + distance[i][a] + distance[i][b], answer);
        }
        return answer;
    }
}
