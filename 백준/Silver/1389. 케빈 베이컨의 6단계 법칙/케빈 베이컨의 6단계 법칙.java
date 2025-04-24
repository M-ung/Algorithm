import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int count;
    public static List<List<Integer>> graph;
    public static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new LinkedList<>();
        result = new int[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            result[i] = bfs(i);
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (result[i] < min) {
                min = result[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        queue.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next: graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }
        int sum = 0;
        for(int i=1; i<=n; i++) {
            sum += dist[i];
        }
        return sum;
    }
}
