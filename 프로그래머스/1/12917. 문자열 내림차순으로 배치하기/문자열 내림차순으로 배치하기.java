import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        for(char c : charArr) {
            answer = answer + c;
        }
        return new StringBuilder(answer).reverse().toString();
    }
}