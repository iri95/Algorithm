import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj16678_모독 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        int x = 0;
        long answer = 0;
        int index = 1;
        for (int i = 0; i < N; i++) {
            if (index <= list[i]) {
                answer += (long) list[i] - index;
                index++;
            }
        }

        System.out.println(answer);
    }
}
