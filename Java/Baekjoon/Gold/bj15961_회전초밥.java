package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15961_회전초밥 {
    static int N, d, k, c;
    static int[] list, visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visit = new int[d + 1];
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(slide());

    }

    static int slide() {
        int total = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (visit[list[i]] == 0) total++;
            visit[list[i]]++;
        }

        max = total;
        for (int i = 1; i <= N; i++) {
            if (max <= total) {
                if (visit[c] == 0) max = total + 1;
                else max = total;
            }
            // 처음 수 삭제 및 개수 수정
            visit[list[i - 1]]--;
            if (visit[list[i - 1]] == 0) total--;

            // 마지막 수가 새로운 수인지 확인 및 개수 수정
            if (visit[list[(i + k - 1) % N]] == 0) total++;
            visit[list[(i + k - 1) % N]]++;
        }
        return max;
    }
}