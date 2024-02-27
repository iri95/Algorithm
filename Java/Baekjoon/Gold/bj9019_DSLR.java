package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj9019_DSLR {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            boolean[] visit = new boolean[100001];
            Queue<String[]> queue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            int end = Integer.parseInt(st.nextToken());
            queue.add(new String[]{start, ""});
            while (!queue.isEmpty()) {
                String[] p = queue.poll();
                int str = Integer.parseInt(p[0]);
                String cul = p[1];
                if (str == end) {
                    sb.append(cul).append("\n");
                    break;
                }
                int D = (str * 2 % 10000);
                int S = ((str + 9999) % 10000);
                if (!visit[D]) {
                    visit[D] = true;
                    queue.add(new String[]{D + "", cul + "D"});
                }
                if (!visit[S]) {
                    visit[S] = true;
                    queue.add(new String[]{S + "", cul + "S"});
                }
                // 무조건 4자릿 수임 없으며 0이다.
                StringBuilder strL= new StringBuilder(p[0]);
                for (int i = 0; i < 4 - p[0].length(); i++) {
                    strL.insert(0, "0");
                }
                int L = Integer.parseInt(strL.substring(1) + strL.charAt(0));
                if (!visit[L]) {
                    visit[L] = true;
                    queue.add(new String[]{L + "", cul + "L"});
                }
                int R = Integer.parseInt(strL.charAt(3) + strL.substring(0, 3));
                if (!visit[R]) {
                    visit[R] = true;
                    queue.add(new String[]{R + "", cul + "R"});
                }


            }
        }
        System.out.println(sb);
    }
}
