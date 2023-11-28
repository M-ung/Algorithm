import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 횟수 입력
        Stack<Integer> stack = new Stack<>(); // 수를 넣을 스택

        for (int i = 0; i < N; i++) {
            int index;
            index = sc.nextInt();
            if (index == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(index);
            }
        }
        
        int sum = 0; // 총합
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        System.out.println(sum);
        sc.close();
    }
}
