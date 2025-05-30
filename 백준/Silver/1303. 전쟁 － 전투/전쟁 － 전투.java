import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    if(map[i][j] == 'W') {
                        white += bfs(i, j);
                    } else if(map[i][j] == 'B') {
                        blue += bfs(i, j);
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    private static int bfs(int x, int y) {
        int count = 0;
        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            count++;
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] == map[cx][cy]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return count*count;
    }
}