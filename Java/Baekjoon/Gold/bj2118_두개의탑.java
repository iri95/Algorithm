package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/source/77788398
public class bj2118_두개의탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int lenSum = 0;
        int[] lens = new int[N];
        for (int i = 0; i < N; i++) {
            lens[i] = Integer.parseInt(br.readLine());
            lenSum += lens[i];
        }
        int ans = 0;
        int start = 0;
        int end = 0;
        int sum = lens[0];
        while (start < N) {
            if (sum <= lenSum / 2){
                ans = Math.max(sum, ans);
                end++;
                sum += lens[end % N];
            }else{
                sum -= lens[start];
                start++;
            }
        }

        System.out.println(ans);
    }
}
