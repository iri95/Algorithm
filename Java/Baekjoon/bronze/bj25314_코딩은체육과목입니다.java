package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj25314_코딩은체육과목입니다 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int roof = N / 4;
        for (int i = 0; i < roof; i++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}
