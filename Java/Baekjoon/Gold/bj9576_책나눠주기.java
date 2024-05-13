package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class bj9576_책나눠주기 {
    static int N, M;
    static int[] num;
    static boolean[] visited;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            num = new int[N + 1];
            list = new ArrayList[M + 1];
            for (int i = 0; i <= M; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                for (int j = s; j <= e; j++) {
                    list[i].add(j);
                }
            }
            int count = 0;
            visited = new boolean[N + 1];
            for (int i = 1; i <= M; i++) {
                Arrays.fill(visited, false);
                if (dfs(i)) count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static boolean dfs(int number) {
        for (int p : list[number]) {
            if (!visited[p]) {
                visited[p] = true;
                if (num[p] == 0 || dfs(num[p])) {
                    num[p] = number;
                    return true;
                }
            }
        }
        return false;
    }
}
/* https://www.acmicpc.net/source/52013320 Greedy
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static boolean[] books;

    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            books = new boolean[n + 1];
            solve();
        }

        System.out.println(ans);
    }

    public static void solve() throws IOException{
        PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                if (s1.b == s2.b) {
                    return s1.a - s2.a;
                }

                return s1.b - s2.b;
            }
        });
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.offer(new Student(a, b));
        }

        int ansCnt = 0;
        while (!queue.isEmpty()) {
            Student cur = queue.poll();
            int a = cur.a;
            int b = cur.b;

            for (int i = a; i <= b; i++) {
                if (!books[i]) {
                    books[i] = true;
                    ansCnt++;
                    break;
                }
            }
        }


        ans.append(ansCnt).append("\n");
    }


    public static class Student{
        int a;
        int b;

        public Student(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
 */