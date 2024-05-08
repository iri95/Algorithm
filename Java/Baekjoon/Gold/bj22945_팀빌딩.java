package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj22945_팀빌딩 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++)
            list[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int start = 0;
        int end = N - 1;
        while (start < end) {
            if (list[start] > list[end]) {
                answer = Math.max(answer, (end - start - 1) * list[end]);
                end--;
            } else if (list[end] > list[start]) {
                answer = Math.max(answer, (end - start - 1) * list[start]);
                start++;
            } else {
                answer = Math.max(answer, (end - start - 1) * list[start]);
                start++;
                end--;
            }
        }
        System.out.println(answer);
    }
}
