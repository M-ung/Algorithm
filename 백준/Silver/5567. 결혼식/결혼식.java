import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n+1];

        bfs();
    }

    private static void bfs() {
        List<Integer> queue = new ArrayList<>();
        queue.add(1);
        visited[1] = true;
        int depth = 0;
        int count = 0;

        while (!queue.isEmpty() && depth < 2) {
            List<Integer> nextQueue = new ArrayList<>();
            for (int node : queue) {
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        nextQueue.add(neighbor);
                        count++;
                    }
                }
            }
            queue = nextQueue;
            depth++;
        }

        System.out.println(count);
    }
}