import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        for (int size : course) {
            Map<String, Integer> countMap = new HashMap<>();
            int maxCount = 0;

            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr); 
                findCombinations(new String(arr), size, 0, "", countMap);
            }

            for (int count : countMap.values()) {
                maxCount = Math.max(maxCount, count);
            }

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == maxCount && maxCount >= 2) {
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void findCombinations(String order, int size, int index, String current, Map<String, Integer> countMap) {
        if (current.length() == size) {
            countMap.put(current, countMap.getOrDefault(current, 0) + 1);
            return;
        }

        for (int i = index; i < order.length(); i++) {
            findCombinations(order, size, i + 1, current + order.charAt(i), countMap);
        }
    }
}