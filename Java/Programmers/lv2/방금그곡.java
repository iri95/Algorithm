package lv2;

import java.util.Arrays;
import java.util.StringTokenizer;

// A#, C#, D#, F#, G# -> H I J K L
public class 방금그곡 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        m = m.replace("A#", "H");
        m = m.replace("C#", "I");
        m = m.replace("D#", "J");
        m = m.replace("F#", "K");
        m = m.replace("G#", "L");
        Song[] songs = new Song[musicinfos.length];
        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            songs[i] = new Song(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
        }
        Arrays.sort(songs);
        int result = -1;
        for (int i = 0; i < songs.length; i++) {
            Song song = songs[i];
            StringBuilder str = new StringBuilder();
            int count = 0;
            while (count < song.time) {
                int index = count % song.music.length();
                str.append(song.music.charAt(index));
                count++;
            }
            String stringStr = str.toString();
            if (stringStr.contains(m)) {
                result = i;
                break;
            }
        }
        if (result == -1) answer = "(None)";
        else answer = songs[result].title;

        return answer;
    }

    static class Song implements Comparable<Song> {
        int startH;
        int startM;
        int endH;
        int endM;
        int time;
        String title;
        String music;

        public Song(String start, String end, String title, String music) {
            music = music.replace("A#", "H");
            music = music.replace("C#", "I");
            music = music.replace("D#", "J");
            music = music.replace("F#", "K");
            music = music.replace("G#", "L");
            String[] sL = start.split(":");
            String[] eL = end.split(":");
            this.startH = Integer.parseInt(sL[0]);
            this.startM = Integer.parseInt(sL[1]);
            this.endH = Integer.parseInt(eL[0]);
            this.endM = Integer.parseInt(eL[1]);
            this.title = title;
            this.music = music;
            if (startH < endH || (startH == endH && startM <= endM))
                this.time = (this.endH - this.startH) * 60 + this.endM - this.startM;
            else this.time = (24 - this.startH) * 60 - this.startM;
        }

        @Override
        public int compareTo(Song o) {
            return o.time - this.time;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}
