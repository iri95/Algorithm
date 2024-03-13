package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj19539_사과나무 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < N; i++) {
            int water  = Integer.parseInt(st.nextToken());
            two += water / 2;
            one += water % 2;
            sum += water;
        }
        if (sum % 3 != 0) {
            System.out.println("NO");
            return;
        }
        if (one <= two) {
            two -= one;
            if (two % 3 == 0) System.out.println("YES");
            else System.out.println("NO");
        } else{
            System.out.println("NO");
        }
    }
}
