package lv3;

public class 가장긴팰린드롬 {
    public int solution(String s) {
        int answer = 1;
        char[] chars = s.toCharArray();
        int N = s.length();
        boolean[][] isPalindrome = new boolean[N][N];
        for (int i = 0; i < N; i++) isPalindrome[i][i] = true;
        for (int i = 1; i < N; i++)
            if (chars[i] == chars[i-1]) {
                isPalindrome[i-1][i] = true;
                answer = 2;
            }
        for (int i = 2; i < N; i++) {
            for (int j = 0; j + i< N; j++) {
                if (isPalindrome[j + 1][i + j - 1] && chars[j] == chars[j + i]) {
                    isPalindrome[j][i + j] = true;
                    answer = Math.max(answer, i + 1);
                }
            }
        }

        return answer;
    }
}
