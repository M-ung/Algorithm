import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean check = true;

        for(int i=0; i < arr.length; i++) {
            int cur = arr[i];
            if(cur >= num) {
                while(cur >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else {
                int pop = stack.pop();
                if (pop > cur) {
                    System.out.println("NO");
                    check = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        if (check) System.out.println(bf.toString());
    }
}
