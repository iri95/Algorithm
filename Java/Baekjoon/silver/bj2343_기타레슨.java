package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://dding9code.tistory.com/99

public class bj2343_기타레슨 {
    static int N, M, mid;
    static int[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            end += list[i];
            start = Math.max(list[i], start);
        }
        while (start <= end) {
            mid = (start + end) / 2;
            int count = getCount();
            if (count > M) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(start);
    }

    static int getCount() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (sum + list[i] > mid) {
                sum = 0;
                count++;
            }
            sum += list[i];
        }
        if (sum != 0) count++;
        return count;
    }
}
