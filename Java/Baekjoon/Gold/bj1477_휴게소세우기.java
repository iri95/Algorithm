package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1477_휴게소세우기 {
    static class Load {
        int start;
        int end;
        int length;
        int count;

        public Load(int start, int end, int length, int count) {
            this.start = start;
            this.end = end;
            this.length = length;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] list = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        list[N + 1] = L;
        Arrays.sort(list);
        Queue<Load> queue = new PriorityQueue<>((o1, o2) -> o2.length - o1.length);
        for (int i = 1; i < N + 2; i++) {
            queue.offer(new Load(list[i - 1], list[i], list[i] - list[i - 1], 0));
        }
        while (M-- > 0) {
            Load load = queue.poll();
            int s = load.start;
            int e = load.end;
            int l = e - s;
            int c = load.count;
            int width = l % (c + 2) == 0 ? l / (c + 2) : l / (c + 2) + 1;
            queue.offer(new Load(s, e, width, c + 1));
        }
        Load load = queue.poll();
        System.out.println(load.length);
    }
}
