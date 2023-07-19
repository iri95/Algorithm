package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// https://bcp0109.tistory.com/156
public class bj13913_숨바꼭질4 {
    static int N, K;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        // 순서대로 구하기 위해 stack 에 담았다가 다시 pop
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        // 최종 출력
        sb.append(time[K] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) return;

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) next = now + 1;
                else if (i == 1) next = now - 1;
                else next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (time[next] == 0) {
                    q.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }
}
/*
 public static class move {
        List<Integer> route = new ArrayList<>();
        int time = 0;
        int site;

        public move(int site) {
            this.route.add(site);
            this.site = site;
        }

        public move(int time, List<Integer> route, int site) {
            this.time = time + 1;
            this.site = site;
            for (int a : route
            ) {
                this.route.add(a);
            }
            this.route.add(site);
        }
    }

    static int N, K;
    static boolean[] visit = new boolean[100001];
    static move[] position = new move[100001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit[N] = true;
        if (N == K) {
            sb.append(0 + "\n");
            sb.append(K + "\n");
        } else {
            bfs(new move(N));
            sb.append(position[K].time + "\n");
            for (int a : position[K].route
            ) {
                sb.append(a + " ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(move n) {
        Queue<move> queue = new ArrayDeque<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                move p = queue.poll();
                int plus = p.site + 1;
                int minus = p.site - 1;
                int multi = p.site * 2;
                if (visit[K]) {
                    return;
                }
                if (plus <= 100000) {
                    if (!visit[plus]) {
                        position[plus] = new move(p.time, p.route, plus);
                        queue.offer(position[plus]);
                        visit[plus] = true;
                    }

                }
                if (minus >= 0) {
                    if (!visit[minus]) {
                        position[minus] = new move(p.time, p.route, minus);
                        queue.offer(position[minus]);
                        visit[minus] = true;
                    }
                }
                if (multi <= 100000) {
                    if (!visit[multi]) {
                        position[multi] = new move(p.time, p.route, multi);
                        queue.offer(position[multi]);
                        visit[multi] = true;
                    }
                }
                position[p.site] = null;
            }
            if (visit[K]) return;
        }
    }
}
 */