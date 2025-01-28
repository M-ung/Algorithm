import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!Character.isAlphabetic(c)) {
                sb.append(" ");
                count = 0;
            } else {
                if(count % 2 == 0) { // 짝수
                    sb.append(Character.toUpperCase(c));
                } else if(count % 2 == 1) { // 홀수
                    sb.append(Character.toLowerCase(c));
                }
                count++;
            }
        }
        return sb.toString();
    }
}