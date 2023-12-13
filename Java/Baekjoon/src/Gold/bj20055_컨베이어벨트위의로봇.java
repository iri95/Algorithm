package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20055_컨베이어벨트위의로봇 {
    static int N, K, cnt, count;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        belt = new int[N * 2];
        robot = new boolean[N];
        cnt = 0; // 내구도 0 인 칸 개수
        count = 0; // 단계
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
            if (belt[i] <= 0) {
                cnt++;
            }
        }
        while (cnt < K) {
            count++;
            Rotate();
            move();
            Raise();
        }
        System.out.println(count);

    }

    // 회전 -> 로봇과 칸이 한칸씩 이동
    static void Rotate() {
        int n = belt[N * 2 - 1];
        boolean r = robot[N - 1];
        for (int i = N * 2 - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        belt[0] = n;
        robot[0] = r;
    }

    // 로봇 이동 -> 첫 로봇부터 회전 방향으로 내구도가 0이 아닐 시 이동
    static void move() {
        robot[0] = false;
        robot[N - 1] = false;
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i]) {
                if (!robot[i + 1] && belt[i + 1] != 0) {
                    robot[i + 1] = true;
                    robot[i] = false;
                    belt[i + 1]--;
                    if (belt[i + 1] == 0) cnt++;
                }
            }
        }
    }

    // 로봇 올림 -> N 칸이 내구도 0이 아닐경우 로봇 올림
    static void Raise() {
        if (belt[0] != 0 && !robot[0]) {
            robot[0] = true;
            belt[0]--;
            if (belt[0] == 0) cnt++;
        }
    }
}
