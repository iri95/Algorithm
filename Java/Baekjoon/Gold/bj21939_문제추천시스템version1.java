package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj21939_문제추천시스템version1 {
    private static class Question {
        int num, dif;

        public Question(int num, int dif) {
            this.num = num;
            this.dif = dif;
        }
    }

    static Map<Integer, Integer> map = new HashMap<>();
    static Queue<Question> pqLow = new PriorityQueue<>((o1, o2) -> {
        if (o1.dif == o2.dif) return o1.num - o2.num;
        return o1.dif - o2.dif;
    });
    static Queue<Question> pqHigh = new PriorityQueue<>((o1, o2) -> {
        if (o1.dif == o2.dif) return o2.num - o1.num;
        return o2.dif - o1.dif;
    });
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Question q = new Question(n, d);
            pqLow.add(q);
            pqHigh.add(q);
            map.put(n, d);
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (input.equals("add")) {
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                add(n, d);
            } else if (input.equals("recommend")) recommend(Integer.parseInt(st.nextToken()));
            else solved(Integer.parseInt(st.nextToken()));

        }
        System.out.println(sb);
    }

    private static void recommend(int x) {
        if (x == 1) {
            while (true) {
                Question q = pqHigh.peek();
                if (q.dif == map.get(q.num)) {
                    sb.append(q.num);
                    break;
                } else pqHigh.poll();
            }
        } else {
            while (true) {
                Question q = pqLow.peek();
                if (q.dif == map.get(q.num)) {
                    sb.append(q.num);
                    break;
                } else pqLow.poll();
            }
        }
        sb.append("\n");
    }

    private static void add(int P, int L) {
        Question q = new Question(P, L);
        pqLow.add(q);
        pqHigh.add(q);
        map.put(P, L);
    }

    private static void solved(int P) {
        map.put(P, -1);
    }
}