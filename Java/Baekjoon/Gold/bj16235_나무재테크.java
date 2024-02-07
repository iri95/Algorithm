package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-16235-%EB%82%98%EB%AC%B4-%EC%9E%AC%ED%85%8C%ED%81%AC-java
public class bj16235_나무재테크 {
    static class Tree {
        int age;
        int x;
        int y;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    static int N, M, K;
    static int[] dy = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dx = {1, -1, 0, 1, -1, 0, -1, 1};
    static int[][] nutrition, A;
    static Deque<Tree> list;
    static Queue<Tree> die;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nutrition = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                nutrition[i][j] = 5;
            }
        }
        list = new LinkedList<>();
        die = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        while (K-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }
        System.out.println(list.size());
    }

    // 봄 : 어린나이 선, 나이만큼 양분 먹음, 나이++, 못먹으면 죽음
    static void spring() {
        for (int i = 0; i < list.size(); ) {
            Tree tree = list.poll();
            if (tree.age > nutrition[tree.x][tree.y]) {
                die.add(tree);
            } else {
                nutrition[tree.x][tree.y] -= tree.age;
                tree.age++;
                list.add(tree);
                i++;
            }
        }
    }

    // 여름 : 죽은 나무 양분으로 -> 양분 + 나이 / 2
    static void summer() {
        while (!die.isEmpty()) {
            Tree tree = die.poll();
            nutrition[tree.x][tree.y] += tree.age / 2;
        }
    }

    // 가을 : 번식 -> 나이 % 5 == 0, 나이 1
    static void fall() {
        Queue<Tree> q = new ArrayDeque<>();
        for (Tree tree : list) {
            if (tree.age % 5 == 0) {
                q.add(tree);
            }
        }
        while (!q.isEmpty()) {
            Tree tree = q.poll();
            for (int j = 0; j < 8; j++) {
                int ny = tree.y + dy[j];
                int nx = tree.x + dx[j];
                if (ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
                list.addFirst(new Tree(nx, ny, 1));
            }
        }
    }

    // 겨울 : 양분에 A[r][c] 추가
    static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nutrition[i][j] += A[i][j];
            }
        }
    }
}
