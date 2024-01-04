package silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj2535_아시아정보올림피아드 {
    public static class Student implements Comparable<Student>{
        int nation;
        int number;
        int score;

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }

        public Student(int nation, int number, int score){
            this.nation = nation;
            this.number = number;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] list = new Student[N];
        Map<Integer, Integer> nationMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            list[i] = new Student(nation, number, score);
            nationMap.put(nation, 0);
        }
        Arrays.sort(list);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(nationMap.get(list[i].nation) == 2) continue;
            if(cnt == 3) break;
            cnt++;
            nationMap.put(list[i].nation, nationMap.get(list[i].nation) + 1);
            System.out.println(list[i].nation + " " + list[i].number);
        }

    }
}
