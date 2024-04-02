package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
1에서 앞 뒤로 bfs 돌려서 방문처리 모두 된다면 확인 가능 아니면 불가능
 */
public class bj2458_키순서 {

    static class Student{
        List<Integer> high = new ArrayList<>();
        List<Integer> low = new ArrayList<>();
    }

    static int N, M;
    static Student[] students;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        students = new Student[N + 1];
        for (int i = 0; i <= N; i++) {
            students[i] = new Student();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            students[low].high.add(high);
            students[high].low.add(low);
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (bfs(i))count++;
        }
        System.out.println(count);
    }
    static boolean bfs(int num) {
        boolean[] visit = new boolean[N + 1];
        visit[num] = true;
        int count = 0;
        Queue<Integer> highQueue = new ArrayDeque<>();
        Queue<Integer> lowQueue = new ArrayDeque<>();
        highQueue.add(num);
        lowQueue.add(num);
        while (!highQueue.isEmpty()) {
            int n = highQueue.poll();
            for (int k : students[n].high) {
                if (visit[k]) continue;
                highQueue.add(k);
                visit[k] = true;
                count++;
            }
        }
        while (!lowQueue.isEmpty()) {
            int n = lowQueue.poll();
            for (int k : students[n].low) {
                if (visit[k]) continue;
                lowQueue.add(k);
                visit[k] = true;
                count++;
            }
        }

        return count >= N - 1;
    }
}
