package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj20492_세금 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(n - n / 100 * 22 + " ");
        System.out.print(n - n / 100 * 20 / 100 * 22);

    }
}
