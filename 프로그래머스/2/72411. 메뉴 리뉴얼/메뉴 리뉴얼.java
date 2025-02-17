import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        for(int c : course) {
            int max = 0;
            Map<String, Integer> maps = new HashMap<String, Integer>(); 
            for(String order : orders) {
                char[] chr = order.toCharArray();
                Arrays.sort(chr);
                backTrack(new String(chr), "", c, 0, maps);
            }
            for(int count : maps.values()) {
                max = Math.max(max, count);
            }
            for (Map.Entry<String, Integer> entry : maps.entrySet()) {
                if (entry.getValue() == max && max >= 2) {
                    result.add(entry.getKey());
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    private static void backTrack(String order, String current, int course, int index, Map<String, Integer> maps) {
        if(current.length() == course) {
            maps.put(current, maps.getOrDefault(current, 0) + 1);
            return;
        }
        for(int i=index; i<order.length(); i++) {
            backTrack(order, current + order.charAt(i), course, i+1, maps);
        }
    }
}