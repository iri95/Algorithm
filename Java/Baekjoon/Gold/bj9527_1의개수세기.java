package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://gre-eny.tistory.com/209
public class bj9527_1의개수세기 {
    static long[] bit = new long[55]; // 2^ 54 > 10 ^ 16
    public static void main(String[] args) throws Exception {
        setBit();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(countBit(b) - countBit(a - 1));
    }
    static void setBit(){
        bit[0] = 1;
        for (int i = 1; i < 55; i++) {
            bit[i] = bit[i - 1] * 2 + (1L << i);
        }
    }
    static long countBit(long x){
        long result = x & 1; // 아래의 반복문에서 i == 0 일 때는 고려하지 않기 때문
        for (int i = 54; i > 0; i--) {
            if ((x & (1L << i)) > 0){
                result += bit[i - 1] + (x - (1L << i) + 1);
                x -= (1L << i);
            }
        }

        return result;
    }
}
