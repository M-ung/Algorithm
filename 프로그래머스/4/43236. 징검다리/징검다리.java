import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int[] newRocks = Arrays.copyOf(rocks, rocks.length + 1);
        newRocks[rocks.length] = distance;  
        
        int low = 1;
        int high = distance;
        int answer = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2; 
            int count = 0;
            int prev = 0; 
            
            for (int rock : newRocks) {
                if (rock - prev < mid) {  
                    count++;
                    if (count > n) break;
                } else {
                    prev = rock;  
                }
            }
            
            if (count > n) {  
                high = mid - 1;
            } else { 
                answer = mid;
                low = mid + 1; 
            }
        }
        
        return answer;
    }
}