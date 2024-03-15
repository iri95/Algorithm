package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 파일명정렬 {
    static class File implements Comparable<File> {
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String sum(){
            return this.head + this.number + this.tail;
        }

        public int compareTo(File o) {
            String thisHead = this.head.toUpperCase();
            String oHead = o.head.toUpperCase();
            if (thisHead.compareTo(oHead) == 0) {
                return Integer.parseInt(this.number) - Integer.parseInt(o.number);
            }
            return thisHead.compareTo(oHead);
        }
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            int sub1 = 0;
            int sub2 = files[i].length();
            for (int j = 0; j < files[i].length(); j++) {
                if (files[i].charAt(j) <= '9' && files[i].charAt(j) >= '0') {
                    sub1 = j;
                    break;
                }
            }
            for (int j = sub1; j < files[i].length(); j++) {
                if (files[i].charAt(j) < '0' || files[i].charAt(j) > '9') {
                    sub2 = j;
                    break;
                }
            }
            list.add(new File(files[i].substring(0, sub1), files[i].substring(sub1, sub2), files[i].substring(sub2)));
        }
        Collections.sort(list);
        for (int i = 0; i < files.length; i++) {
            answer[i] = list.get(i).sum();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }
}
