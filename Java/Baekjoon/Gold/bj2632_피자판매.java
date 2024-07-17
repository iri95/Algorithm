package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2632_피자판매 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] A = new int[n];
        int[] B = new int[m];
        int[] aCount = new int[size];
        aCount[0]++;
        int all = 0;
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
            all += A[i];
        }
        if (all == size) ans++;
        else if (all < size) aCount[all]++;
        all = 0;
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(br.readLine());
            all += B[i];
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < i + n - 1; j++) {
                sum += A[j % n];
                if (sum < size) {
                    aCount[sum]++;
                } else if (sum == size) {
                    ans++;
                    break;
                } else break;
            }
        }
        if (all <= size) ans += aCount[size - all];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < i + m - 1; j++) {
                sum += B[j % m];
                if (sum <= size) ans += aCount[size - sum];
                else break;
            }
        }
        System.out.println(ans);

    }
}
