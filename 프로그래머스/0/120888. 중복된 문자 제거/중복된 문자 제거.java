import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> charSet = new LinkedHashSet<>();
        
        for(int i=0; i< my_string.length(); i++) {
            char chr = my_string.charAt(i);
            charSet.add(chr);
        }
        

        StringBuilder sb = new StringBuilder();
        for (Character ch : charSet) {
            sb.append(ch);
        }
        String result = sb.toString();
        return result;
    }
}