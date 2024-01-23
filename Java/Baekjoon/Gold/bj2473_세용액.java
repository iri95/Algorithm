package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2473_세용액 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] list = new long[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int low = 0;
        int mid = 0;
        int high = 0;
        long minAbs = 3000_000_001L;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 2; j < N; j++) {
                int a = i;
                int b = j;
                while (a <= b) {
                    int m = (a + b) / 2;
                    long k = Math.abs(list[i] + list[m] + list[j]);
                    if (k == 0 && i != m && j != m) {
                        System.out.println(list[i] + " " + list[m] + " " + list[j]);
                        return;
                    }
                    if (k < minAbs && m != i && m != j) {
                        minAbs = k;
                        low = i;
                        mid = m;
                        high = j;
                    }
                    if (list[i] + list[m] + list[j] < 0) {
                        a = m + 1;
                    } else {
                        b = m - 1;
                    }
                }
            }
        }
        System.out.println(list[low] + " " + list[mid] + " " + list[high]);
    }
}
