import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj12738_가장긴증가하는부분수열3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> result = new ArrayList<>();
        result.add(list[0]);
        for (int i = 1; i < N; i++) {
            if (list[i] > result.get(result.size() - 1)) {
                result.add(list[i]);
            } else {
                int k = Collections.binarySearch(result, list[i]);
                if (k < 0){
                    result.set((k + 1) * (-1), list[i]);
                }
            }
        }
        System.out.println(result.size());
    }
}
