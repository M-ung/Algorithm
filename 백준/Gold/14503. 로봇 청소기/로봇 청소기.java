import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int r, c, d;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(result);
    }
    private static void bfs() {
        visited[r][c] = true;
        result++;

        while (true) {
            boolean found = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0 && !visited[nr][nc]) {
                    r = nr;
                    c = nc;
                    visited[r][c] = true;
                    result++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                int backDir = (d + 2) % 4;
                int br = r + dr[backDir];
                int bc = c + dc[backDir];

                if (br >= 0 && br < n && bc >= 0 && bc < m && map[br][bc] == 0) {
                    r = br;
                    c = bc;
                } else {
                    break;
                }
            }
        }
    }
}