package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2110_공유기설치 {
    static int N, C;
    static int[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int start = 1;
        int end = list[N - 1] - list[0] + 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (getCount(mid) >= C) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(start -1);
    }

    public static int getCount(int mid) {
        int prev = list[0];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (list[i] - prev >= mid) {
                cnt++;
                prev = list[i];
            }
        }
        return cnt;
    }
}
