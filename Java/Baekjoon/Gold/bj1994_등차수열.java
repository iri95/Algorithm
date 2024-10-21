package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1994_등차수열 {
    static int N;
    static int[] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int ans = 1;
        for(int i = 0; i < N; i++){
            for (int j = i + 1; j < N; j++) {
                if(visited[i][j]) continue;
                if (arr[i] == arr[j]) {
                    int cnt = 1;
                    for (int k = j; k < N; k++) {
                        if (arr[i] == arr[k]) {
                            cnt++;
                            visited[k-1][k] = true;
                        }
                        else break;
                    }
                    ans = Math.max(ans, cnt);
                    continue;
                }
                ans = Math.max(ans, 2 + sol(j, arr[j] - arr[i]));
            }
        }
        System.out.println(ans);
    }
    private static int sol(int i, int n){
        int cnt = 0;
        int s = arr[i] + n;
        int now = i;
        while(true){
            int next = binarySearch(s);
            if(next != -1) {
                visited[now][next] = true;
                now = next;
                cnt++;
                s += n;
            }
            else break;
        }
        return cnt;
    }

    private static int binarySearch(int value){
        int s = 0;
        int e = N;
        while(s < e) {
            int m = (s + e)/ 2;
            if (arr[m] == value) return m;
            else if (arr[m] < value) s = m + 1;
            else e = m;
        }
        return -1;
    }
}
