package Platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10266_시계사진들 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int[] target = new int[n];
        int[] arr = new int[n * 2];
        for (int i = 0; i < n - 1; i++) {
            target[i] = a[i + 1] - a[i];
            arr[i] = arr[i + n] = b[i + 1] - b[i];
        }
        target[n - 1] = 360_000 + a[0] - a[n - 1];
        arr[n - 1] = arr[n * 2 - 1] = 360_000 + b[0] - b[n - 1];
        // KMP
        int[] table = new int[n];
        int idx = 0;
        for(int i = 1; i < n; i ++){
            while(idx > 0 && target[idx] != target[i])
                idx = table[idx - 1];

            if (target[i] == target[idx])
                table[i] = ++idx;
        }

        idx = 0;
        for(int i = 0; i < n * 2; i ++){
            while(idx > 0 && target[idx] != arr[i])
                idx = table[idx - 1];

            if (arr[i] == target[idx]){
                if (idx == n - 1){
                    System.out.println("possible");
                    return;
                } else
                    idx++;
            }
        }
        System.out.println("impossible");
    }
}
