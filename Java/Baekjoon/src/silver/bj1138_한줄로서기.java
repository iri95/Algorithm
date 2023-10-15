package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1138_한줄로서기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> result = new ArrayList<>();
        for (int i = N; i > 0 ; i--) {
            result.add(list[i], i);
        }
        for (int a : result
             ) {
            System.out.print(a + " ");
        }
    }
}
