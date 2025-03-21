import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Song>> songs = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            map.put(genre, map.getOrDefault(genre, 0) + play);
            songs.putIfAbsent(genre, new ArrayList<>());
            songs.get(genre).add(new Song(i, play));
        }
        List<Map.Entry<String, Integer>> sortedMap = new ArrayList<>(map.entrySet());
        sortedMap.sort((a, b) -> b.getValue() - a.getValue());
        
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : sortedMap) {
            String genre = entry.getKey();
            List<Song> songList = songs.get(genre);
            songList.sort((a, b) -> b.play - a.play == 0 ? a.idx - b.idx : b.play - a.play);
            result.add(songList.get(0).idx);
            if (songList.size() > 1) {
                result.add(songList.get(1).idx);
            }

        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Song {
        private int idx;
        private int play;
        public Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        public int getIdx() { return this.idx; }
        public int getPlay() { return this.play; }
    }
}