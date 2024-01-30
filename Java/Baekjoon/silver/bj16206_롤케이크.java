package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16206_롤케이크 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] list = new int[1001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[Integer.parseInt(st.nextToken())]++;
        }
        int max = list[10];
        for (int i = 1; i < M + 1; i++) {
            if (list[20] > 0) {
                list[20]--;
                list[10] += 2;
                max = list[10];
            } else {
                boolean end = false;
                for (int j = 30; j < 1001; j += 10) {
                    if (list[j] > 0) {
                        list[j]--;
                        list[j - 10]++;
                        list[10]++;
                        max = list[10];
                        end = true;
                        break;
                    }
                }
                if (end) continue;
                for (int j = 11; j < 1001; j++) {
                    if (list[j] > 0) {
                        list[j]--;
                        list[j - 10]++;
                        list[10]++;
                        max = list[10];
                        break;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
