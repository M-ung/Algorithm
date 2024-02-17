import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            poll(queue);
            back(queue);
        }
        System.out.println(queue.poll());
    }
    private static Queue<Integer> poll(Queue<Integer> queue) {
        queue.poll();
        return queue;
    }
    private static Queue<Integer> back(Queue<Integer> queue) {
        queue.add(queue.poll());
        return queue;
    }
}
