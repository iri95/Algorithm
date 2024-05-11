package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16434_드래곤엔던전 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());
        long answer = 0;
        long sum = 0;
        long a, life, t, cure;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                a = Long.parseLong(st.nextToken());
                life = Long.parseLong(st.nextToken());
                sum += a * (life / atk - (life % atk == 0 ? 1 : 0));
                answer = Math.max(answer, sum);
            } else {
                atk += Long.parseLong(st.nextToken());
                cure = Long.parseLong(st.nextToken());
                sum = sum - cure >= 0 ? sum - cure : 0;
            }
        }
        answer++;
        System.out.println(answer);
    }
}
