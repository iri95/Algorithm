package lv2;

import java.math.BigInteger;

public class 멀쩡한사각형 {
    public static long solution(int w, int h) {
        long answer = (long) w * h;
        int gcd = new BigInteger(String.valueOf(w)).gcd(new BigInteger(String.valueOf(h))).intValue();
        answer -= h + w - gcd;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }
}
