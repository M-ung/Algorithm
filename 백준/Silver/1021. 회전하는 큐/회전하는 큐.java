import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            deque.offer(i);
        }

        int count = 0;
        for(int i=0; i<m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int idx = 0;

            for (int num : deque) {
                if (num == target) {
                    break;
                }
                idx++;
            }
            int half = deque.size() / 2;
            if (idx <= half) {
                for (int j = 0; j < idx; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - idx; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}