package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj14003_가장긴증가하는부분수열5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> result = new ArrayList<>();
        int[] index = new int[N];
        result.add(list[0]);
        for (int i = 1; i < N; i++) {
            if (list[i] > result.get(result.size() - 1)) {
                result.add(list[i]);
                index[i] = result.size() - 1;
            } else {
                int k = Collections.binarySearch(result, list[i]);
                if (k < 0){
                    result.set((k + 1) * (-1), list[i]);
                    index[i] = (k + 1) * (-1);
                }else{
                    index[i] = k;
                }
            }
        }
        int size = result.size();
        System.out.println(size);
        int[] answer = new int[size];
        size--;
        for (int i = N - 1; i >= 0 ; i--) {
            if (size == index[i]) {
                answer[size] = list[i];
                size--;
            }
            if (size < 0)break;
        };
        for (int i = 0; i < result.size(); i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
