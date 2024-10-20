package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj9007_카누선수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[4][n];
            int[] sum01 = new int[n * n];
            int[] sum23 = new int[n * n];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sum01[n * i + j] = arr[0][i] + arr[1][j];
                    sum23[n * i + j] = arr[2][i] + arr[3][j];
                }
            }
            Arrays.sort(sum01);
            Arrays.sort(sum23);
            int answer = sum01[0] + sum23[0];
            int s = 0;
            int e = n * n - 1;
            while(s < n * n && e >= 0){
                int sum = sum01[s] + sum23[e];
                if(Math.abs(k - sum) == Math.abs(k - answer)){
                    if (sum < answer) answer = sum;
                }else if(Math.abs(k - sum) < Math.abs(k - answer)) answer = sum;
                if(sum < k) s++;
                else e--;
                if (answer == k) break;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

}
