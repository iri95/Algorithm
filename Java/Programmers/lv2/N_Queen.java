package lv2;

public class N_Queen {
    static int answer = 0;
    static boolean[] row;
    static boolean[] rCross;
    static boolean[] lCross;
    public int solution(int n) {
        row = new boolean[n];
        rCross = new boolean[2 * n - 1];
        lCross = new boolean[2 * n - 1];
        recursion(0, n);
        return answer;
    }

    private static void recursion(int x, int n){
        if(x == n){
            answer++;
            return;
        }
        for(int i = 0; i < n; i++){
            int rc = n + (i - x) - 1;
            int lc = x + i;
            if(row[i] || rCross[rc] || lCross[lc]) continue;
            row[i] = true; rCross[rc] = true; lCross[lc] = true;
            recursion(x + 1, n);
            row[i] = false; rCross[rc] = false; lCross[lc] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
