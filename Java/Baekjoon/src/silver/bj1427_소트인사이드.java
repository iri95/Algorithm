package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class bj1427_소트인사이드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] list = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            list[i] = Character.getNumericValue(str.charAt(i));
        }
        Arrays.sort(list);
        for (int i = list.length - 1; i >= 0; i--) {
            System.out.print(list[i]);
        }
    }
}
