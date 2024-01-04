package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10813_공바꾸기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            list[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = list[a];
            list[a] = list[b];
            list[b] = temp;
        }
        for (int i = 1; i < N+1; i++) {
            System.out.print(list[i] + " ");
        }


    }
}
