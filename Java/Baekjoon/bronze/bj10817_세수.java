package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10817_세수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[3];
        a[0] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());
        a[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        System.out.println(a[1]);
    }
}
