import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int r, c;
    public static char[][] arr;
    public static boolean[] visited;
    public static int max = -999;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[26];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        visited[arr[0][0] - 'A'] = true; 
        dfs(0, 0, 1);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                int alphaIdx = arr[nx][ny] - 'A';
                if (!visited[alphaIdx]) {
                    visited[alphaIdx] = true;
                    dfs(nx, ny, count + 1);
                    visited[alphaIdx] = false;
                }
            }
        }
    }
}