import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs)
                return o1 > o2 ? 1:-1;
            else
                return first_abs - second_abs;
        }));

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int request = Integer.parseInt(st.nextToken());
            if(request == 0) {
                if(priorityQueue.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    System.out.println(priorityQueue.poll());
                }
            }
            else {
                priorityQueue.add(request);
            }
        }
    }
}
