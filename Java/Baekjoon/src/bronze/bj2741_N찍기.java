package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2741_N찍기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for (int i = 1; i <= a; i++) {
            System.out.println(i);
        }
    }
}
