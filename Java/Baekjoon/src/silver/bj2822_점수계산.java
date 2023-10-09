package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2822_점수계산 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[9];
        for (int i = 1; i < 9; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        int[] sortList = Arrays.copyOfRange(Arrays.stream(list).sorted().toArray(), 4, 9);
        System.out.println(Arrays.stream(sortList).sum());

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                if(list[i] == sortList[j]){
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }
}
