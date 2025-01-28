import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> answer = new ArrayList<>();
        String st = Long.toString(n);
        for (int i = 0; i < st.length(); i++) {
            answer.add(Character.getNumericValue(st.charAt(st.length() - i - 1)));
        }
        return answer.stream().mapToInt(i -> i).toArray(); 
    }
}