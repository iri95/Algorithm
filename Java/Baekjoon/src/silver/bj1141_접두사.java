package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class bj1141_접두사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] list = new String[N];
        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }
        Arrays.sort(list, Comparator.reverseOrder());
        int cnt = N;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int len = list[i].length();
                if (len > list[j].length())break;
                String front = list[j].substring(0, len);
                if (list[i].equals(front)) {
                    cnt--;
                    list[i] = list[j];
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
