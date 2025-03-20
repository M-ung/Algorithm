import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        int circulation = s.length();
        List<Character> list = new ArrayList<>();
        for(int i=0; i<circulation; i++) {
            char c = s.charAt(i);
            list.add(c);
        }
        for(int i=0; i<circulation; i++) {
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for(int j=0; j<list.size(); j++) {
                char c = list.get(j);
                if(c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        check = false;
                    } else {
                        stack.pop();
                    }
                } else if (c == '(') {
                    stack.push(c);
                }
                else if(c == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        check = false;
                    } else {
                        stack.pop();
                    }
                } else if (c == '{') {
                    stack.push(c);
                }
                else if(c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        check = false;
                    } else {
                        stack.pop();
                    }
                } else if (c == '[') {
                    stack.push(c);
                }
            }
            if(check && stack.isEmpty()) {
                count++;
            }
            char first = list.remove(0);
            list.add(first);
        }
        return count;
    }
}