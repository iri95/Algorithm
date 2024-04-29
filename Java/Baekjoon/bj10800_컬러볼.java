import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10800_컬러볼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] balls = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            balls[i][0] = Integer.parseInt(st.nextToken());
            balls[i][1] = Integer.parseInt(st.nextToken());
            balls[i][2] = i;
        }
        Arrays.sort(balls, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        int sum = 0;
        int[] numberSum = new int[N + 1];
        int sizeSum = 0;
        int[] numSizeSum = new int[N + 1];
        int[] answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (balls[i - 1][1] == balls[i][1] && balls[i-1][0] == balls[i][0]) numSizeSum[i] = numSizeSum[i - 1] + 1;
            if (balls[i-1][1] == balls[i][1]) sizeSum += balls[i][1];
            else sizeSum = 0;
            numberSum[balls[i][0]] += balls[i][1];
            sum += balls[i][1];
            answer[balls[i][2]] = sum - numberSum[balls[i][0]] - sizeSum + numSizeSum[i] * balls[i][1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);


    }
}
