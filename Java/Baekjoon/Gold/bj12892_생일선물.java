package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj12892_생일선물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] list = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list, Comparator.comparing(o -> o[0]));
        int index = 1;
        long sum = 0;
        long max = 0;
        for (int i = 1; i <= N && index <= N; i++) {
            while (index <= N) {
                if (list[index][0] - list[i][0] < D) {
                    sum += list[index][1];
                    index++;
                } else break;
            }
            max = Math.max(max, sum);
            sum -= list[i][1];
        }
        System.out.println(max);

    }
}
