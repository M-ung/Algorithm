import java.util.*;

public class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>(countMap.values());
        countList.sort((a, b) -> b - a);
        
        int sum = 0;
        int answer = 0;
        for (int count : countList) {
            sum += count;
            answer++;
            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}
