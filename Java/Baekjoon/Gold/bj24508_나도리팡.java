package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj24508_나도리팡 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] boxes = new int[N];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
            sum += boxes[i];
        }
        if (sum % K != 0) {
            System.out.println("NO");
            return;
        }
        Arrays.sort(boxes);
        int s = 0;
        int e = N - 1;
        long cnt = 0;
        while (s < e) {
            int need = K - boxes[e];
            if (need <= boxes[s]) {
                boxes[s] -= need;
                cnt += need;
                e--;
             } else{
                cnt += boxes[s];
                boxes[e] += boxes[s++];
            }
        }
        System.out.println(cnt <= T ? "YES" : "NO");
    }
}
