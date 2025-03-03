package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1377_버블소트 {
    private static class Num implements Comparable<Num> {
        int number;
        int index;

        Num(int number, int idx) {
            this.number = number;
            this.index = idx;
        }

        public int compareTo(Num n) {
            return this.number - n.number;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Num[] arr = new Num[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Num(Integer.parseInt(br.readLine()), i);

        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < N - result; i++)
            result = Math.max(result, arr[i].index - i);

        System.out.println(result + 1);
    }
}
