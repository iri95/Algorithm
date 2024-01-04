package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj16637_괄호추가하기 {
    static int N, result;
    static int[] num;
    static char[] operation;
    static boolean[] select;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String a = br.readLine();
        num = new int[N / 2 + 1];
        operation = new char[N / 2];
        select = new boolean[N / 2];
        result = Integer.MIN_VALUE;
        num[0] = Character.getNumericValue(a.charAt(0));
        for (int i = 1; i <= N/2; i++) {
            operation[i - 1] = a.charAt(2 * i-1);
            num[i] = Character.getNumericValue(a.charAt(2 * i));
        }
        if(N == 1){
            result = num[0];
        }else {
            subset(0);
        }
        System.out.println(result);

    }
    static void subset(int srcIdx){
        if (srcIdx >= N / 2) {
            ArrayList<Character> arrayO = new ArrayList<>();
            ArrayList<Integer> arrayN = new ArrayList<>();
            for (int i = 0; i < N/2; i++) {
                if (select[i]) {
                    if (operation[i] == '+') {
                        arrayN.add((num[i] + num[i + 1]));
                    } else if (operation[i] == '-') {
                        arrayN.add((num[i] - num[i + 1]));
                    } else if (operation[i] == '*') {
                        arrayN.add((num[i] * num[i + 1]));
                    }
                }else{
                    if (i == 0) {
                        if(N/2 == 1){
                            arrayN.add(num[0]);
                            arrayO.add(operation[i]);
                            arrayN.add(num[1]);
                        }else {
                            arrayN.add(num[0]);
                            arrayO.add(operation[i]);
                        }
                    }
                    if(i > 0 && select[i-1]) {
                        if (i == N / 2 - 1) {
                            arrayO.add(operation[i]);
                            arrayN.add(num[i+1]);
                        }else{
                            arrayO.add(operation[i]);
                        }
                    } else if (i > 0 && !select[i - 1]) {
                        if (i == N / 2 - 1) {
                            arrayN.add(num[i]);
                            arrayO.add(operation[i]);
                            arrayN.add(num[i + 1]);
                        }else {
                            arrayN.add(num[i]);
                            arrayO.add(operation[i]);
                        }
                    }
                }
            }
            int a = arrayN.get(0);
            for (int i = 0; i < arrayO.size(); i++) {
                if (arrayO.get(i) == '+') {
                    a += arrayN.get(i + 1);
                } else if (arrayO.get(i) == '-') {
                    a -= arrayN.get(i + 1);
                }else{
                    a *= arrayN.get(i + 1);
                }
            }
            result = Math.max(result, a);
            return;
        }
        if (srcIdx >= N) {
            return;
        }
        select[srcIdx] = true;
        subset(srcIdx + 2);
        select[srcIdx] = false;
        subset(srcIdx + 1);
    }
}
