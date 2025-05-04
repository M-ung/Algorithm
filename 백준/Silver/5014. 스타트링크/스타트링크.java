import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f, s, g, u, d;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new boolean[f + 1];

        int result = bfs();

        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }
    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});
        visited[s] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int count = cur[1];

            if (now == g) return count;

            int up = now + u;
            if(up <= f && !visited[up]) {
                queue.offer(new int[]{up, count + 1});
                visited[up] = true;
            }

            int down = now - d;
            if(down >= 1 && !visited[down]) {
                queue.offer(new int[]{down, count + 1});
                visited[down] = true;
            }
        }
        return -1;
    }
}