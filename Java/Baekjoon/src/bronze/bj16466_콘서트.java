package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16466_콘서트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] list = new boolean[1000001];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            list[a] = true;
        }
        for (int i = 1; i < 1000001; i++) {
            if(!list[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
