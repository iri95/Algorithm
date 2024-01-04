package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/board/view/100363
public class bj2437_저울 {
    static int N;
    static int[] list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        long cnt=0;
        long ans=0;
        for(int i=0;i<N-1;i++) {
            cnt+= list[i];

            if((cnt+1)<list[i+1]) {
                ans = cnt+1;
                break;
            };
        }

        if(list[0]>1) {
            ans = 1;
        }else if(ans==0) {
            ans= cnt+list[N-1]+1;
        }

        System.out.println(ans);
    }
}
