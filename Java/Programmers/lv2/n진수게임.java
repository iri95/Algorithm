package lv2;

public class n진수게임 {
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        int k = t * m;
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        for (int i = 0; i <= t * m; i++) {
            sb.append(str(n, i));
        }

        for (int i = 0; i < t; i++) {
            answer += sb.charAt(m * i + p - 1);
        }
        return answer;
    }

    static String str(int n, int num) {
        if (num == 0) return "";
        if (n < 11) return str(n, num / n) + num % n;
        else return str(n, num / n) + (num % n >= 10 ? Character.toString('A' + num % n - 10) : num % n);
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));

    }
}
