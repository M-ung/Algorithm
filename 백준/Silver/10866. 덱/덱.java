
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>() {};

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());           
            String command = st.nextToken();
            switch(command) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        sb.append("\n");
                    } else {
                        sb.append("-1");
                        sb.append("\n");
                    }
                    break;
                case "pop_back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        sb.append("\n");
                    } else {
                        sb.append("-1");
                        sb.append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if (!deque.isEmpty()) {
                        sb.append("0");
                        sb.append("\n");
                    } else {
                        sb.append("1");
                        sb.append("\n");
                    }
                    break;
                case "front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekFirst());
                        sb.append("\n");
                    } else {
                        sb.append("-1");
                        sb.append("\n");
                    }
                    break;
                case "back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast());
                        sb.append("\n");
                    } else {
                        sb.append("-1");
                        sb.append("\n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
