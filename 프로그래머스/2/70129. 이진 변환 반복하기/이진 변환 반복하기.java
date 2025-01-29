import java.util.*;

class Solution {
    public int[] solution(String s) {
        int totalCount = 0;
        int[] answer = new int[2];
        int circle = 0;
        int nowCount = 0;
        while(true) {
            circle++;
            int nowLength = 0;
            for(int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(c == '0') {
                    nowCount++;
                }
            }
            s = s.replace("0", "");
            nowLength = s.length();
            s = change(nowLength);
            if (s.equals("1")) {
                break; 
            }
        }
        answer[0] = circle;
        answer[1] = nowCount;
        return answer;
    }
    public static String change(int nowLength) {
        StringBuilder sb = new StringBuilder();
        while(nowLength >= 1) {
            int a = nowLength % 2;
            nowLength = nowLength / 2;
            sb.append(Integer.toString(a));
        }
        sb.reverse();
        return sb.toString();
    }
}