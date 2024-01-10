package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14891_톱니바퀴 {
    static int[][] cogs = new int[4][8];
    static boolean[] visit = new boolean[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String cog = br.readLine();
            for (int j = 0; j < 8; j++) {
                cogs[i][j] = cog.charAt(j) - '0';
            }
        }
        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            visit = new boolean[4];
            rotation(number, direction);
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += cogs[i][0] * (int) (Math.pow(2, i));
        }
        System.out.println(sum);
    }

    static void rotation(int number, int direction) {
        if (visit[number]) return;
        visit[number] = true;
        int next = number + 1;
        int before = number - 1;
        if (direction == 1) {
            if (next <= 3 && cogs[number][2] != cogs[next][6]) rotation(next, -1);
            if (before >= 0 && cogs[number][6] != cogs[before][2]) rotation(before, -1);
            right(number);
        } else {
            if (next <= 3 && cogs[number][2] != cogs[next][6]) rotation(next, 1);
            if (before >= 0 && cogs[number][6] != cogs[before][2]) rotation(before, 1);
            left(number);
        }
    }

    static void right(int number) {
        int k = cogs[number][7];
        for (int i = 7; i > 0; i--) {
            cogs[number][i] = cogs[number][i - 1];
        }
        cogs[number][0] = k;
    }

    static void left(int number) {
        int k = cogs[number][0];
        for (int i = 0; i < 7; i++) {
            cogs[number][i] = cogs[number][i + 1];
        }
        cogs[number][7] = k;
    }
}
