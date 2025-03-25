import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int idx = 0;
        int total = 0;
        int count = 0;
        Stack<Character> stack = new Stack<>();
        while(!stack.isEmpty() || idx < str.length()) {
            char c = str.charAt(idx);
            if(c == '(') {
                stack.push(c);
                count++;
            } else if(str.charAt(idx-1) == '(' && (c == ')')) { // 레이저 일 때
                stack.pop();
                count--;
                total += count;
            } else if(str.charAt(idx-1) == ')' && (c == ')')) { // 레이저가 아닐 때
                stack.pop();
                count--;
                total += 1;
            }
            idx++;
        }
        System.out.println(total);
    }
}