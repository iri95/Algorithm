package lv2;

public class 방문길이 {
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][] visit1 = new boolean[11][10]; // 가로선
        boolean[][] visit2 = new boolean[10][11]; // 세로선
        int[] point = {5, 5};
        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'U') {
                if (point[0] - 1 < 0) continue;
                point[0]--;
                if (!visit2[point[0]][point[1]]) {
                    visit2[point[0]][point[1]] = true;
                    answer++;
                }
            } else if (dirs.charAt(i) == 'D') {
                if (point[0] + 1 > 10) continue;
                if (!visit2[point[0]][point[1]]) {
                    visit2[point[0]][point[1]] = true;
                    answer++;
                }
                point[0]++;
            } else if (dirs.charAt(i) == 'R') {
                if (point[1] + 1 > 10) continue;
                if (!visit1[point[0]][point[1]]) {
                    visit1[point[0]][point[1]] = true;
                    answer++;
                }
                point[1]++;
            } else {
                if (point[1] - 1 < 0) continue;
                point[1]--;
                if (!visit1[point[0]][point[1]]) {
                    visit1[point[0]][point[1]] = true;
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }
}
