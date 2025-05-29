import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[101];

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

        bfs();
    }

    private static void bfs() {
        boolean[] visited = new boolean[101];
        int[] distance = new int[101];
        visited[1] = true;
        distance[1] = 0;

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if (next > 100) continue;

                next = board[next];

                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        System.out.println(distance[100]);
    }
}
