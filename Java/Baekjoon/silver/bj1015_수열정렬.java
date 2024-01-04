package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1015_수열정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] A = new int[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = Arrays.stream(A).sorted().toArray();
        boolean[] visit = new boolean[a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (A[i] == B[j] && !visit[j]) {
                    sb.append(j).append(" ");
                    visit[j] = true;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
