package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2776_암기왕 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[N];
            for (int j = 0; j < N; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] b = new int[M];
            for (int j = 0; j < M; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (Arrays.binarySearch(a, k) < 0) {
                    sb.append(0).append("\n");
                }else{
                    sb.append(1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
