package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// Gold Greedy bj2590_색종이
public class bj2590_색종이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[7];
        for (int i = 1; i <= 6; i++)
            count[i] = Integer.parseInt(br.readLine());

        // 6
        int result = count[6];

        // 5
        result += count[5];
        count[1] -= 11 * count[5];

        // 4
        result += count[4];
        count[2] -= 5 * count[4];
        if (count[2] < 0)
            count[1] -= -count[2] * 4;


        // 3
        if (count[3] > 0) {
            result += (count[3] - 1) / 4 + 1;
            count[3] %= 4;
            if (count[3] == 1) {
                if (count[2] >= 5) {
                    count[2] -= 5;
                    count[1] -= 7;
                } else if(count[2] > 0){
                    count[1] -= 27 - count[2] * 4;
                    count[2] = 0;
                }else{
                    count[1] -= 27;
                }
            } else if (count[3] == 2) {
                if (count[2] >= 3) {
                    count[2] -= 3;
                    count[1] -= 6;
                } else if(count[2] > 0){
                    count[1] -= 18 - count[2] * 4;
                    count[2] = 0;
                }else{
                    count[1] -= 18;
                }
            } else if (count[3] == 3) {
                if (count[2] >= 1) {
                    count[2]--;
                    count[1] -= 5;
                } else {
                    count[1] -= 9;
                }
            }
        }

        // 2
        if (count[2] > 0) {
            result += (count[2] - 1) / 9 + 1;
            count[2] %= 9;
            if (count[2] != 0) count[1] -= 36 - count[2] * 4;
        }


        // 1
        if (count[1] > 0) {
            result += (count[1] - 1) / 36 + 1;
        }

        System.out.println(result);
    }
}
