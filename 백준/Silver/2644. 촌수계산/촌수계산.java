import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int start;
    public static int end;
    public static int m;
    public static List<List<Integer>> graph;
    public static boolean[] visited;
    public static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        graph = new LinkedList<>();
        visited = new boolean[n+1];
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

        dfs(start, 0);
        System.out.println(result);
    }
    private static void dfs(int current, int depth) {
        if (current == end) {
            result = depth;
            return;
        }

        visited[current] = true;
        for (int next : graph.get(current)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}