package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1091_카드섞기 {
    static int N;
    static int[] list, origin, next;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        origin = new int[N];
        next = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            list[i] = origin[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            next[i] = Integer.parseInt(st.nextToken());

        if (end()) System.out.println(0);
        else System.out.println(shuffle());

    }

    private static int shuffle() {
        int[] temp = new int[N];
        int count = 0;
        while (true) {
            count++;
            for (int i = 0; i < N; i++) temp[i] = list[i];
            for (int i = 0; i < N; i++) list[next[i]] = temp[i];
            if (isCycle()) return -1;
            if (end()) return count;
        }
    }

    private static boolean isCycle() {
        for (int i = 0; i < N; i++)
            if (origin[i] != list[i]) return false;
        return true;
    }

    private static boolean end() {
        for (int i = 0; i < N; i++)
            if (list[i] != i % 3) return false;
        return true;
    }
}
