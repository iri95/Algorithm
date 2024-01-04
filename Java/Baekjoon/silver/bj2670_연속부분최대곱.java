package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2670_연속부분최대곱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] list = new double[N+1];
        for (int i = 1; i < N+1; i++) {
            list[i] = Double.parseDouble(br.readLine());
        }
        double result = 0;
        for (int i = 1; i < N; i++) {
            list[i] = Math.max(list[i], list[i] * list[i - 1]);
            result = Math.max(result, list[i]);
        }
        System.out.printf("%.3f",result);
    }
}
