import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int min = Integer.MAX_VALUE;
    public static int[][] matrix;
    static boolean[] visited;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }
        System.out.println(min);
    }
    private static void dfs(int start, int now, int cost, int depth) {
        if (depth == n - 1) {
            if (matrix[now][start] != 0) {
                min = Math.min(min, cost + matrix[now][start]);
            }
            return;
        }
        for(int i = 0; i < n; i++) {
            if (!visited[i] && matrix[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + matrix[now][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
