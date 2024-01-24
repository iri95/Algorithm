package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2629_양팔저울 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] can = new boolean[15001];
        can[0] = true;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nList[i] = Integer.parseInt(st.nextToken());
            sum += nList[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = sum; j >= 0; j--) {
                if (can[j] && j + nList[i] < 15001) can[j + nList[i]] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= sum; j++) {
                if (can[j] && j - nList[i] >= 0) can[j - nList[i]] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] mList = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mList[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (mList[i] >= 15001) {
                sb.append("N ");
                continue;
            }
            if (can[mList[i]]) sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb);
    }
}
