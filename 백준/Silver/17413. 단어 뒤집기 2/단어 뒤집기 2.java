import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                queue.offer(c);
                int idx = i+1;
                while(!queue.isEmpty()) {
                    char ch = str.charAt(idx);
                    if(ch == '>') {
                        queue.offer(ch);
                        while(!queue.isEmpty()) {
                            sb.append(queue.poll());
                        }
                        break;
                    } else {
                        queue.offer(ch);
                        idx++;
                    }
                }
                i = idx;
            } else {
                if(c == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

}
