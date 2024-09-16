package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj2036_수열의정수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int zero = 0;
        List<Integer> mList = new ArrayList<>();
        List<Integer> pList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) zero++;
            else if (n < 0) mList.add(n);
            else pList.add(n);
        }
        Collections.sort(mList);
        Collections.sort(pList);
        long sum = 0;
        if (pList.size() % 2 == 0) {
            for (int i = 0; i < pList.size(); i += 2) {
                long a = (long) pList.get(i);
                long b = (long) pList.get(i + 1);
                if (a == 1 || b == 1) sum += a + b;
                else sum += a * b;
            }
        } else {
            sum += pList.get(0);
            for (int i = 1; i < pList.size(); i += 2) {
                long a = (long) pList.get(i);
                long b = (long) pList.get(i + 1);
                if (a == 1 || b == 1) sum += a + b;
                else sum += a * b;
            }
        }
        if (mList.size() % 2 == 0) {
            for (int i = 0; i < mList.size(); i += 2)
                sum += (long) mList.get(i) * mList.get(i + 1);
        } else {
            if (zero == 0) sum += mList.get(mList.size() - 1);
            for (int i = 0; i < mList.size() - 1; i += 2)
                sum += (long) mList.get(i) * mList.get(i + 1);
        }
        System.out.println(sum);
    }
}
