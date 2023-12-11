import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1713_후보추천하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] list = new int[101][2];
        for (int i = 1; i <= length; i++) {
            int num = Integer.parseInt(st.nextToken());
            int size = 0;
            int number = 0;
            int cnt = 1001;
            int time = 1001;
            boolean[] visit = new boolean[101];
            for (int j = 1; j < 101; j++) {
                if (list[j][0] != 0) {
                    size++;
                    visit[j] = true;
                    if (list[j][0] < cnt) {
                        number = j;
                        cnt = list[j][0];
                        time = list[j][1];
                    } else if (list[j][0] == cnt) {
                        if (list[j][1] < time) {
                            number = j;
                            cnt = list[j][0];
                            time = list[j][1];
                        }
                    }
                }
            }
            if (size == N) {
                if (visit[num]) {
                    list[num][0]++;
                }else {
                    list[number][0] = 0;
                    list[number][1] = 0;
                    list[num][0]++;
                    list[num][1] = i;
                }
            }else{
                if (visit[num]){
                    list[num][0]++;
                }else {
                    list[num][0]++;
                    list[num][1] = i;
                }
            }
        }
        for (int i = 1; i < 101; i++) {
            if (list[i][0] != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
