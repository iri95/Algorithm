package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2467_용액 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int min = -1000_000_001;
        int max = 1000_000_000;
        int minAbs = 2000_000_001;
        for (int i = 0; i < N; i++) {
            int minIndex = 0;
            int maxIndex = N - 1;
            while (minIndex <= maxIndex) {
                int mid = (minIndex + maxIndex) / 2;
                if (Math.abs(list[i] + list[mid]) < minAbs && mid != i) {
                    minAbs = Math.abs(list[i] + list[mid]);
                    if (i > mid) {
                        min = list[mid];
                        max = list[i];
                    } else if (i < mid) {
                        min = list[i];
                        max = list[mid];
                    }
                }
                if (list[mid] > (-1) * list[i]) {
                    maxIndex = mid - 1;
                } else {
                    minIndex = mid + 1;
                }
            }
        }
        System.out.println(min + " " + max);
    }
}
