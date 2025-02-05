package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj30805_사전순최대공통부분수열 {
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        List<Integer> B = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) B.add(Integer.parseInt(st.nextToken()));
        sol(A, B);

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for(int val : answer) sb.append(val).append(" ");
        System.out.println(sb);
    }

    private static void sol(List<Integer> A, List<Integer> B) {
        if (A.isEmpty() || B.isEmpty()) return;
        int maxA = Collections.max(A);
        int indexA = A.indexOf(maxA);
        int maxB = Collections.max(B);
        int indexB = B.indexOf(maxB);

        if (maxA > maxB) {
            A.remove(indexA);
            sol(A, B);
        } else if (maxA < maxB) {
            B.remove(indexB);
            sol(A, B);
        } else {
            answer.add(maxA);
            sol(A.subList(indexA + 1, A.size()), B.subList(indexB + 1, B.size()));
        }
    }
}
