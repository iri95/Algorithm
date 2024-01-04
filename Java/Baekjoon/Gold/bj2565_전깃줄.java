package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj2565_전깃줄 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[0] > o2[0]) return 1;
            else if (o1[0] < o2[0]) return -1;
            else return 0;
        });
        List<Integer> dpList = new ArrayList<>();
        dpList.add(list.get(0)[1]);
        for (int i = 1; i < N; i++) {
            if (list.get(i)[1] > dpList.get(dpList.size() - 1)) {
                dpList.add(list.get(i)[1]);
            }else{
                int k = Math.abs(Collections.binarySearch(dpList, list.get(i)[1]) + 1);
                dpList.set(k, list.get(i)[1]);
            }
        }
        System.out.println(N - dpList.size());

    }
}
