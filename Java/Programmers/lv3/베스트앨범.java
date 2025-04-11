package lv3;

import java.util.*;

public class 베스트앨범 {
    private static class Song implements Comparable<Song> {
        int no, count;

        Song(int n, int c) {
            this.no = n;
            this.count = c;
        }

        public int compareTo(Song s) {
            if (this.count == s.count) return this.no - s.no;
            return s.count - this.count;
        }
    }

    private static class Genre implements Comparable<Genre> {
        int count = 0;
        List<Song> songs = new ArrayList<>();

        Genre() {
        }

        public void addSong(Song s) {
            this.count += s.count;
            songs.add(s);
        }

        public int compareTo(Genre g) {
            return g.count - this.count;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> map = new HashMap<>();
        int N = genres.length;
        for (int i = 0; i < N; i++) {
            if (map.getOrDefault(genres[i], null) == null)
                map.put(genres[i], new Genre());

            map.get(genres[i]).addSong(new Song(i, plays[i]));
        }

        List<Genre> list = new ArrayList<>(map.values());

        Collections.sort(list);

        List<Integer> ans = new ArrayList<>();
        for (Genre genre : list) {
            int idx = 0;
            Collections.sort(genre.songs);
            int max = Math.min(2, genre.songs.size());
            while (idx < max) {
                ans.add(genre.songs.get(idx).no);
                idx++;
            }
        }

        int[] answer = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);

        return answer;
    }
}