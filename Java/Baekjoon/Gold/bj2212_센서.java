package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2212_센서 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        if (N <= K) {
            System.out.println(0);
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensor = new int[N];
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);
        int[] sensorLength = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            sensorLength[i] = sensor[i + 1] - sensor[i];
        }
        Arrays.sort(sensorLength);
        int answer = 0;
        for (int i = N - 1 - K; i >= 0 ; i--) {
            answer += sensorLength[i];
        }
        System.out.println(answer);
    }
}
