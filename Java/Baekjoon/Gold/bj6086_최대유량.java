package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj6086_최대유량 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] capacity = new int[52][52];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = ascii(st.nextToken().charAt(0));
            int e = ascii(st.nextToken().charAt(0));
            int c = Integer.parseInt(st.nextToken());
            capacity[s][e] += c;
            capacity[e][s] += c;
        }

        int ans = 0;
        int[] parents = new int[52]; // 물의 흐름을 파악하고 목적지에 도달할 수 있는 지 파악하기 위한 배열
        int[][] flow = new int[52][52]; // 현재 유량의 상태를 저장하는 2차원 배열
        Queue<Integer> q = new ArrayDeque<>(); // BFS를 위한 Queue
        while(true) {
            Arrays.fill(parents, -1);
            parents[0] = 0;
            q.add(0);

            // 목적지까지 도달할 수 있는 지 확인
            while(!q.isEmpty() && parents[25] == -1){
                int cur = q.poll();
                for (int i = 0; i < 52; i++) {
                    // 용량이 남아있고 이미 방문하지 않는 상태일 경우. parents를 확인하지 않으면 Circle이 존재할 수 있음.
                    if(capacity[cur][i] - flow[cur][i] > 0 && parents[i] == -1){
                        q.add(i);
                        parents[i] = cur;
                    }
                }
            }
            // 목적지에 도달하지 못하면 break;
            if (parents[25] == -1) break;

            // 현재 상태에서 최대 유량을 구한다.
            int count = Integer.MAX_VALUE;
            for (int i = 25; i != 0 ; i = parents[i])
                count = Math.min(count, capacity[parents[i]][i] - flow[parents[i]][i]);

            // 유량을 더해준다.
            for (int i = 25; i != 0; i = parents[i]) {
                flow[parents[i]][i] += count;
                flow[i][parents[i]] -= count;
            }

            q.clear();
            ans += count;
        }
        System.out.println(ans);
    }

    // 아스키코드로 알파벳 대소문자를 숫자로 변환하는 함수.
    private static int ascii(char c) {
        if ('A' <= c && c <= 'Z') return c - 'A';
        else return c - 'A' - 6;
    }
}
