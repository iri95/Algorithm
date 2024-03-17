public class 추석트래픽 {
    static class Times implements Comparable<Times> {
        int start;
        int end;

        public Times(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Times o) {
            return this.start - o.start;
        }
    }

    public static int solution(String[] lines) {
        int answer = 1;
        int N = lines.length;
        Times[] times = new Times[N];
        for (int i = 0; i < N; i++) {
            /*
            11~12 H  * 60 * 60 * 1000
            14~15 M  * 60 * 1000
            17~18 S  * 1000
            20~22 ms
            24~end - 1 T length가 1이 아니면 소수점 존재
             */
            int H = Integer.parseInt(lines[i].substring(11, 13)) * 60 * 60 * 1000;
            int M = Integer.parseInt(lines[i].substring(14, 16)) * 60 * 1000;
            int S = Integer.parseInt(lines[i].substring(17, 19)) * 1000;
            int ms = Integer.parseInt(lines[i].substring(20, 23));
            int T = Integer.parseInt(lines[i].substring(24, 25)) * 1000 - 1;
            if (lines[i].length() - 1 - 24 != 1) {
                int pow = 3 - (lines[i].length() - 1 - 26);
                T += (int) (Integer.parseInt(lines[i].substring(26, lines[i].length() - 1)) * Math.pow(10, pow));
            }
            times[i] = new Times(H + M + S + ms - T, H + M + S + ms);
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (times[i].start + 999 >= times[j].start && times[i].start <= times[j].end) count++;
            }
            answer = Math.max(count, answer);
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (times[i].end + 999 >= times[j].start && times[i].end <= times[j].end) count++;
            }
            answer = Math.max(count, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"
        }));
        System.out.println(solution(new String[]{
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"
        }));
        System.out.println(solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        }));
    }
}
