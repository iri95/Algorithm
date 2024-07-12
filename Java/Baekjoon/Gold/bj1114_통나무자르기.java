package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1114_통나무자르기 {

    static int L, K, C;
    static int[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new int[K + 2];
        list[0] = 0;
        list[K + 1] = L;
        for (int i = 1; i <= K; i++) list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        int s = 0;
        int e = L;
        int ansFirst = L;
        while (s < e) {
            int mid = (s + e) / 2;
            int k = binary(mid);
            if (k == -1) s = mid + 1;
            else {
                e = mid;
                ansFirst = k;
            }
        }
        System.out.println(e + " " + ansFirst);
    }

    private static int binary(int maxLen) {
        int first = L;
        int cnt = 0;
        int sum = 0;
        for (int i = K; i >= 0; i--) {
            if (list[i + 1] - list[i] > maxLen) return -1;
            sum += list[i + 1] - list[i];
            if (sum > maxLen) {
                sum = list[i + 1] - list[i];
                first = list[i + 1];
                cnt++;
            }
        }
        if (cnt > C) return -1;
        return cnt < C ? list[1] : first;
    }
}
