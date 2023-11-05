package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj28417_스케이트보드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] runList = new int[N][2];
        int[][] trackList = new int[N][5];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                runList[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < 5; j++) {
                trackList[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(runList[i]);
            Arrays.sort(trackList[i]);
            max = Integer.max(max, runList[i][1] + trackList[i][3] + trackList[i][4]);
        }
        System.out.println(max);

    }
}
