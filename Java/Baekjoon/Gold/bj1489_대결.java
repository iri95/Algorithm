package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1489_대결 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] > B[j] && B[j] != 0) {
                    A[i] = 0;
                    B[j] = 0;
                    max += 2;
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if(A[i] == 0)continue;
            for (int j = N-1; j >= 0; j--) {
                if (Objects.equals(A[i], B[j])) {
                    max++;
                    B[j] = 0;
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
