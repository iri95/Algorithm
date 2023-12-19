package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://sup-report.tistory.com/108
public class bj1756_피자 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dList = new int[D];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            dList[i] = Integer.parseInt(st.nextToken());
            if (i != 0) {
                dList[i] = dList[i] > dList[i - 1] ? dList[i - 1] : dList[i];
            }
        }
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = 1;
        int value = 0;
        for (int i = D - 1; i >= 0; i--) {
            if (n <= dList[i]) {
                cnt++;
                if (cnt > N) {
                    value = i + 1;
                    break;
                }
                if (i == 0) {
                    value = 0;
                    break;
                }
                n = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(value);
    }
}
