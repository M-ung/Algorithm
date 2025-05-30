import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        distance = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i< n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(current == n - 1) {
                System.out.println(distance[current]);
                return;
            }

            for(int i = 1; i <= arr[current]; i++) {
                int next = current + i;
                if(next < n && !visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
        
        System.out.println(-1);
    }
}