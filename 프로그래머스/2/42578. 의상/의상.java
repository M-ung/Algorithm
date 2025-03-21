import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        int result = 1;
        for (int count : clothesMap.values()) {
            result *= (count + 1);
        }
        return result-1;
    }
}