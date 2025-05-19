import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, k;
    static char[][] map;
    static int count = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
        }

        visited[r-1][0] = true;
        dfs(1, r-1, 0);

        System.out.println(count);
    }

    private static void dfs(int depth, int i, int j) {
        if(i == 0 && j == c - 1) {
            if(depth == k) count++;
            return;
        }

        for(int t = 0; t < 4; t++) {
            int nx = i + dx[t];
            int ny = j + dy[t];
            if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if(!visited[nx][ny] && map[nx][ny] != 'T') {
                    visited[nx][ny] = true;
                    dfs(depth + 1, nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}