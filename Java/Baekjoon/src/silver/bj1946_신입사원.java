package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1946_신입사원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Unit[] list = new Unit[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list[i] = new Unit(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(list);
            int cnt = 1;
            int min = list[0].meeting;
            for (int i = 1; i < N; i++) {
                if (list[i].meeting < min) {
                    cnt++;
                    min = list[i].meeting;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    public static class Unit implements Comparable<Unit>{
        int profile;
        int meeting;

        public Unit(int profile, int meeting) {
            this.profile = profile;
            this.meeting = meeting;
        }

        @Override
        public int compareTo(Unit o) {
            if (profile < o.profile) return -1;
            else return 1;
        }
    }
}
