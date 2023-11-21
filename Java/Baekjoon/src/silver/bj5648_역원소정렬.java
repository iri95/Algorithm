package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj5648_역원소정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] list = new long[N];
        int cnt = 0;
        while (true) {
            if (st.hasMoreTokens()) {
                StringBuilder str = new StringBuilder(st.nextToken());
                list[cnt] = Long.parseLong(str.reverse().toString());
                cnt++;
                if (cnt == N) break;
            } else {
                st = new StringTokenizer(br.readLine());
            }
        }
        Arrays.sort(list);
        for (int i = 0; i < N; i++) {
            System.out.println(list[i]);
        }
    }
}
