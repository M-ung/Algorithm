import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String str : info) {
            String[] words = str.split(" ");
            generateCombinations("", 0, words);
        }

        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String str = query[i].replace(" and ", " ");
            String[] words = str.split(" ");
            String key = words[0] + words[1] + words[2] + words[3];
            int score = Integer.parseInt(words[4]);

            if (map.containsKey(key)) {
                List<Integer> scores = map.get(key);
                answer[i] = scores.size() - lowerBound(scores, score);
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private void generateCombinations(String current, int depth, String[] words) {
        if (depth == 4) {
            int score = Integer.parseInt(words[4]);
            map.computeIfAbsent(current, k -> new ArrayList<>()).add(score);
            return;
        }
        generateCombinations(current + words[depth], depth + 1, words);
        generateCombinations(current + "-", depth + 1, words);
    }

    private int lowerBound(List<Integer> scores, int target) {
        int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}