import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (c == '(') {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}