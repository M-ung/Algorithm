import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                if(c == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                } else {
                    stack.push(c);
                }
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}