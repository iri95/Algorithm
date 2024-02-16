package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1208_부분수열의합2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        List<Integer> sumList1 = new ArrayList<>();
        List<Integer> sumList2 = new ArrayList<>();
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        sumList1.add(0);
        sumList2.add(0);
        long count = 0;
        for (int i = 0; i < N / 2; i++) {
            int size = sumList1.size();
            for (int j = 0; j < size; j++) {
                sumList1.add(sumList1.get(j) + list[i]);
                if (sumList1.get(j) + list[i] == S) count++;
            }
        }
        for (int i = N / 2; i < N; i++) {
            int size = sumList2.size();
            for (int j = 0; j < size; j++) {
                sumList2.add(sumList2.get(j) + list[i]);
                if (sumList2.get(j) + list[i] == S) count++;
            }
        }
        sumList1.remove(0);
        sumList2.remove(0);
        Collections.sort(sumList1);
        Collections.sort(sumList2);
        int size1 = sumList1.size();
        int size2 = sumList2.size();
        int start = 0;
        int end = size2 - 1;
        while (start < size1 && end >= 0) {
            int sum = sumList1.get(start) + sumList2.get(end);
            if (sum == S) {
                int cnt1 = 0;
                int cnt2 = 0;
                int sIndex = start;
                int eIndex = end;
                while (sIndex < size1) {
                    if (Objects.equals(sumList1.get(sIndex), sumList1.get(start))) {
                        cnt1++;
                        sIndex++;
                    } else break;
                }
                while (eIndex >= 0) {
                    if (Objects.equals(sumList2.get(eIndex), sumList2.get(end))) {
                        cnt2++;
                        eIndex--;
                    } else break;
                }
                count += (long) cnt1 * cnt2;
                start = sIndex;
                end = eIndex;
            } else if (sum < S) start++;
            else end--;
        }
        System.out.println(count);
    }
}
