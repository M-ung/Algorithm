import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> ans = new ArrayList<>();
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i=0; i< answers.length; i++) {
            int index = answers[i];
            int index1 = i%5;
            int index2 = i%8;
            int index3 = i%10;
            if(index == person1[index1]) { count1++; }
            if(index == person2[index2]) { count2++; }
            if(index == person3[index3]) { count3++; }
        }
        int max = Math.max(count1, Math.max(count2, count3));
        if(max == count1) ans.add(1);
        if(max == count2) ans.add(2);
        if(max == count3) ans.add(3);
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)  answer[i] = ans.get(i);
        return answer;
    }
}