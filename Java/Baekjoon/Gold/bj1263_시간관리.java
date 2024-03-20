package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1263_시간관리 {
    static class Task implements Comparable<Task>{
        int T;
        int S;

        public Task(int T, int S) {
            this.T = T;
            this.S = S;
        }

        public int compareTo(Task o) {
            if (o.S == this.S) return o.T - this.T;
            return this.S - o.S;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Task[] tasks = new Task[N];
        int Tsum = 0;
        int maxS = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(T, S);
            Tsum += T;
            maxS = Math.max(S, maxS);
        }
        if (maxS - Tsum < 0) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(tasks);
        int answer = tasks[0].S - tasks[0].T; // 가장 늦은 시간
        int time = tasks[0].S; // 전 작업이 끝난 시간
        int remainTime = 0; // 사이사이 남은 시간
        for (int i = 1; i < N; i++) {
            if (tasks[i].S - time < tasks[i].T) {
                if (tasks[i].T - (tasks[i].S - time) <= remainTime) {
                    remainTime -= tasks[i].T - (tasks[i].S - time);
                    time = tasks[i].S;
                }else{
                    answer -= tasks[i].T - (tasks[i].S - time + remainTime);
                    time = tasks[i].S;
                    remainTime = 0;
                }
            }else{
                remainTime += tasks[i].S - tasks[i].T - time;
                time = tasks[i].S;
            }
        }
        System.out.println(answer < 0 ? -1 : answer);
    }
}
