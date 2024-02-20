package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj16562_친구비 {
    static int[] friends;
    static int[] money;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        friends = new int[N + 1];
        money = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            friends[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= N; i++) {
            int p = find(i);
            set.add(p);
        }
        int sum = 0;
        for (int value: set) {
            sum += money[value];
        }
        if (sum > k) System.out.println("Oh no");
        else System.out.println(sum);

    }
    static int find(int x) {
        if (friends[x] == x) return x;
        else return find(friends[x]);
    }

    static void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp < yp){
            friends[yp]= xp;
            money[xp] = Math.min(money[xp], money[yp]);
        }
        else{
            friends[xp] = yp;
            money[yp] = Math.min(money[xp], money[yp]);
        }
    }
}
