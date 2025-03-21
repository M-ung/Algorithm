import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
    
        for(int i=0; i<progresses.length; i++) {
            int left = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            queue.add(left);
        }
        
        int count = 1;
        int preDays = queue.poll();
        
        while(!queue.isEmpty()) {
            int currentDays = queue.poll();
            if(preDays >= currentDays) {
                count++;
            } else {
                result.add(count);
                count = 1;
                preDays = currentDays;
            }
        }
        result.add(count);
        return result.stream().mapToInt(i->i).toArray();
    }
}