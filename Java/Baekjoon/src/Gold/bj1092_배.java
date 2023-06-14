package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1092_배 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] O = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            O[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(C);
        Arrays.sort(O);
        int[] count = new int[N];
        for (int i = N-1; i >= 0 ; i--) {
            for (int j = M-1; j >= 0 ; j--) {
                if(C[i] >= O[j]){
                    count[i] = j;
                    break;
                }
            }
        }
        boolean a = false;

        if (C[N - 1] < O[M - 1]) {
            System.out.println(-1);
            return;
        }
        boolean[] visit = new boolean[M];
        int time = 0;
        int s = 0;
        while(true) {
            for (int i = N - 1; i >= 0; i--) {
                for (int j = count[i]; j >= 0; j--) {
                    if (visit[j]) continue;
                    if (C[i] >= O[j]) {
                        visit[j] = true;
                        s++;
                        break;
                    }
                }
            }
            time++;
            if(s == M)break;
        }
        System.out.println(time);


    }
}
