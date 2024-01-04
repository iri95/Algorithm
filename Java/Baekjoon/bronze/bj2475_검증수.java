package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2475_검증수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int a3 = Integer.parseInt(st.nextToken());
        int a4 = Integer.parseInt(st.nextToken());
        int a5 = Integer.parseInt(st.nextToken());
        System.out.println((a1*a1 + a2*a2 + a3*a3 + a4*a4 + a5* a5)%10);
    }
}
