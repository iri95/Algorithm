package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2295_세수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Binary Search 196ms
                for (int k = 0; k <= j; k++) {
                    int target = list[i] - list[j] - list[k];
                    if (target < 0) break;
                    int start = 0;
                    int end = k;
                    while(start <= end){
                        int mid = (start + end) /2;
                        if (list[mid] > target)end = mid - 1;
                        else if (list[mid] < target)start = mid + 1;
                        else{
                            System.out.println(list[i]);
                            return;
                        }
                    }
                }
                // Two Pointer 276ms
//                int start = 0;
//                int end = j;
//                while (start <= end) {
//                    if (list[start] + list[end] > list[i] - list[j]) end--;
//                    else if (list[start] + list[end] < list[i] - list[j]) start++;
//                    else {
//                        System.out.println(list[i]);
//                        return;
//                    }
//                }
            }
        }
    }
}
