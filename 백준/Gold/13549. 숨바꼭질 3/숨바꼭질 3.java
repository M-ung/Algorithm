import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int[] time = new int[100001];
        Arrays.fill(time, -1);
        time[N] = 0;
        queue.offer(N);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == K) return time[current];
            
            int teleport = current * 2;
            if (teleport <= 100000 && time[teleport] == -1) {
                time[teleport] = time[current]; 
                queue.offer(teleport);
            }
            
            int[] nextMoves = {current - 1, current + 1};
            for (int next : nextMoves) {
                if (next >= 0 && next <= 100000 && time[next] == -1) {
                    time[next] = time[current] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1;
    }
}