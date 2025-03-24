import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
                case "push":
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (!deque.isEmpty()) {
                        sb.append(deque.poll());
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