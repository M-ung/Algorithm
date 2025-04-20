import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static LinkedList[] adjList;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            adjList = createGraph(n);
            visited = new boolean[n];
            count = 0;
            for(int u=0; u<n; u++) {
                int v = Integer.parseInt(st.nextToken()) - 1;
                addEdge(u, v);
            }
            for (int u = 0; u < n; u++) {
                if (!visited[u]) {
                    bfs(u);
                    count++;
                }
            }

            System.out.println(count);
        }

    }

    private static LinkedList[] createGraph(int n) {
        LinkedList[] adjList = new LinkedList[n];

        for (int j = 0; j < n; j++) {
            adjList[j] = new LinkedList<>();
        }
        return adjList;
    }

    private static void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (Object neighbor : adjList[u]) {
                int v = (int) neighbor;
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
