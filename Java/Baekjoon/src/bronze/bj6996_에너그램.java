package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj6996_에너그램 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            String a1 = str1.chars().sorted().collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append)
                    .toString();
            String a2 = str2.chars().sorted().collect(StringBuilder::new,
                    StringBuilder::appendCodePoint,
                    StringBuilder::append)
                    .toString();
            if(a1.equals(a2)){
                System.out.println(str1 + " & " + str2 + " are anagrams.");
            }else{
                System.out.println(str1 + " & " + str2 + " are NOT anagrams.");
            }

        }
    }
}
