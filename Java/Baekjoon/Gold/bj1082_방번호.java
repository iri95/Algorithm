package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1082_방번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (min >= arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        int M = Integer.parseInt(br.readLine());
        int cnt = M / min;
        int remain = M % min;
        StringBuilder sb = new StringBuilder();
        if (minIndex != 0) {
            for (int i = 0; i < cnt; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (remain + min >= arr[j]) {
                        sb.append(j);
                        remain -= arr[j] - min;
                        break;
                    }
                }
            }
        } else {
            int maxCnt = 0;
            int maxIndex = 0;
            for (int i = N - 1; i > 0; i--) {
                if (maxCnt < (M - arr[i]) / min + 1 && M >= arr[i]){
                    maxCnt = (M - arr[i]) / min + 1;
                    remain = (M - arr[i]) % min;
                    maxIndex = i;
                }
            }
            sb.append(maxIndex);
            for (int i = 0; i < maxCnt - 1; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (remain + min >= arr[j]) {
                        sb.append(j);
                        remain -= arr[j] - min;
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
