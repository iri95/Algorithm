package lv2;

public class 점프와순간이동 {
    public static int solution(int n) {
        int ans = 0;
        while (n >= 1) {
            if (n % 2 == 1) ans++;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }
}
