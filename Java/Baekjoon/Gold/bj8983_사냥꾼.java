package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj8983_사냥꾼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] list = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Arrays.binarySearch(list, a);
            if (k < 0) {
                k = k * (-1) - 1;
                if (k == 0) {
                    if (Math.abs(a - list[0]) + b <= L) cnt++;
                } else if (k == M) {
                    if (Math.abs(a - list[M - 1]) + b <= L) cnt++;
                } else {
                    if (Math.abs(a - list[k]) + b <= L || Math.abs(a - list[k - 1]) + b <= L) cnt++;
                }
            } else {
                if (b <= L) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
