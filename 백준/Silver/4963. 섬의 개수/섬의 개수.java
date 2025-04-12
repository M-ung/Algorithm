import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int w, h;
    public static int[][] graph;
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            inputValue(br);
            if(h == 0 && w == 0) break;
            int sum = 0;
            graph = new int[h][w];
            visited = new boolean[h][w];
            createGraph(br, graph);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(graph[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }

    private static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= h || y >= w || visited[x][y] || graph[x][y] == 0) return;

        visited[x][y] = true;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < 8; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }

    private static void createGraph(BufferedReader br, int[][] graph) throws IOException {
        StringTokenizer st;
        for(int i = 0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void inputValue(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
    }
}