package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17951_흩날리는시험지속에서내평점이느껴진거야 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int s = 21;
        int e = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s = Math.min(s, arr[i]);
            e += arr[i];
        }

        while (s <= e) {
            int mid = (s + e) / 2;
            int sum = 0;
            int count = 0;

            for (int cur : arr) {
                sum += cur;

                if (sum >= mid) {
                    count++;
                    sum = 0;
                }
            }

            if (count >= K) s = mid + 1;
            else e = mid - 1;
        }

        System.out.println(s - 1);
    }
}
