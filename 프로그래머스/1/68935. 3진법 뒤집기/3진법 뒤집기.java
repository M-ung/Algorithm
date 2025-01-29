import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        while(n >= 1) {
            int res = n % 3;
            n = n / 3;
            arr.add(res);
        }
    
        for(int i=0; i<arr.size(); i++) {
            answer += (Math.pow(3, i))*(arr.get(arr.size()-i-1));
        }
        
        return answer;
    }
}