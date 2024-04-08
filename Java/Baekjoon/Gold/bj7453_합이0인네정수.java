package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj7453_합이0인네정수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] abSum;
    static int[] cdSum;
    static int[][] lists;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        lists = new int[4][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                lists[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        abSum = new int[n * n];
        cdSum = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                abSum[i * n + j] = lists[0][i] + lists[1][j];
                cdSum[i * n + j] = lists[2][i] + lists[3][j];
            }
        }
        Arrays.sort(abSum);
        Arrays.sort(cdSum);
        System.out.println(getCount());
    }

    private static long getCount() {
        long count = 0;
        int start = 0;
        int end = n * n - 1;
        int ab;
        int cd;
        while (start < n * n && end >= 0) {
            ab = abSum[start];
            cd = cdSum[end];
            if (ab + cd == 0) {
                int abCount = 0;
                int cdCount = 0;
                for (int i = start; i < n * n; i++) {
                    if (ab == abSum[i]) {
                        abCount++;
                    } else break;
                }
                for (int i = end; i >= 0; i--) {
                    if (cd == cdSum[i]) {
                        cdCount++;
                    } else break;
                }
                count += (long) abCount * cdCount;
                start += abCount;
                end -= cdCount;
            } else if (abSum[start] + cdSum[end] < 0) start++;
            else end--;
        }
        return count;
    }
}
