package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2845_파티가끝나고난뒤 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int number = L * P;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            System.out.println(Integer.parseInt(st.nextToken()) - number);
        }

    }
}
