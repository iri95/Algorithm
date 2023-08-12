package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1453_피시방알바 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        boolean[] list = new boolean[101];
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (list[k]) {
                cnt++;
            }else{
                list[k] = true;
            }
        }
        System.out.println(cnt);
    }
}
