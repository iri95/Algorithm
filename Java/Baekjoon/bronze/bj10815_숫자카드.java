package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj10815_숫자카드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] d = new int[M];
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (Arrays.binarySearch(list, a) >= 0) {
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
