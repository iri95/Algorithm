package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj2056_작업 {
    static int N;
    static List<int[]> list = new ArrayList<>();
    static int[] time, finish;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        finish = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int inIndex = Integer.parseInt(st.nextToken());
            int[] in = new int[inIndex];
            for (int j = 0; j < inIndex; j++) {
                in[j] = Integer.parseInt(st.nextToken());
            }
            list.add(in);
        }

        for (int i = 0; i < N; i++) {
            if (list.get(i).length == 0) {
                finish[i + 1] = time[i + 1];
            }
        }

        while (!end()) {
            List<Integer> intlist = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (finish[i + 1] != 0) continue;
                int[] k = list.get(i);
                boolean s = false;
                for (int j = 0; j < k.length; j++) {
                    if (finish[k[j]] == 0) {
                        s = true;
                        break;
                    }
                }
                if (s) continue;
                else intlist.add(i + 1);
            }

            for (int i = 0; i < intlist.size(); i++) {
                int k = intlist.get(i);
                int[] r = list.get(k - 1);
                for (int j = 0; j < r.length; j++) {
                    finish[k] = Math.max(finish[k], time[k] + finish[r[j]]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            result = Math.max(result, finish[i]);
        }

        System.out.println(result);

    }
    static boolean end() {
        for (int i = 1; i <= N; i++) {
            if (finish[i] == 0) return false;
        }
        return true;
    }
}
