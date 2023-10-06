package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1895_필터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] list = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                int[] dump = new int[9];
                for (int k = 0; k < 9; k++) {
                    dump[k] = list[k%3 + i][k/3 + j];
                }
                Arrays.sort(dump);
                result.add(dump[4]);
            }
        }
        Collections.sort(result);
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i)>= T){
                System.out.println(result.size() - i);
                return;
            }
            if(i == result.size()-1) System.out.println(0);
        }
    }
}
