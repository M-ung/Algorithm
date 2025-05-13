import java.util.*;

class Solution {
    public String solution(String s) { 
        s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
        
        
        for(int i=0; i<s.length(); i++) {
            if(i>0) {
                char b = s.charAt(i-1);
                if(b == ' ') {
                    s = s.substring(0,i) + s.substring(i, i+1).toUpperCase() + s.substring(i+1).toLowerCase();
                }
            }
        }
        return s;
    }
}