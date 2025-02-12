import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<commands.length; i++) {
            int startIndex = commands[i][0];
            int endIndex = commands[i][1];
            int findIndex = commands[i][2];
            List<Integer> arr = new ArrayList<>();
            for(int j = startIndex-1; j<endIndex; j++) {
                arr.add(array[j]);
            }
            Collections.sort(arr);
            result.add(arr.get(findIndex-1));
        }
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}