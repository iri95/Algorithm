package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11509_풍선맞추기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, list[i]);
        }
        int[] next = new int[1000001];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (next[list[i]] != 0) {
                next[list[i]]--;
                if (list[i] - 1 > 0) next[list[i] - 1]++;
            } else {
                cnt++;
                if (list[i] - 1 > 0) next[list[i] - 1]++;
            }
        }
        System.out.println(cnt);
    }
}
