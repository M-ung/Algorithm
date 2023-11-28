import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<Integer>();
        int n = sc.nextInt();
        for(int i=1; i<=n; i++)
        {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            queue.poll();
            int temp = queue.poll();
            queue.offer(temp);
        }
        System.out.println(queue.poll());
    }
}
