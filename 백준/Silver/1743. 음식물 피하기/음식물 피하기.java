import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] trashes;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        trashes = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            trashes[r-1][c-1] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(trashes[i-1][j-1] == 1 && !visited[i-1][j-1]) {
                    int result = bfs(i, j);
                    max = Math.max(max, result);
                }
            }
        }

        System.out.println(max == Integer.MIN_VALUE ? -1 : max);
    }

    private static int bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c));
        visited[r-1][c-1] = true;
        int count = 1;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int k=0; k<4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx >= 1 && nx <= trashes.length && ny >= 1 && ny <= trashes[0].length && trashes[nx-1][ny-1] == 1 && !visited[nx-1][ny-1]) {
                    queue.offer(new Point(nx, ny));
                    visited[nx-1][ny-1] = true;
                    count++;
                }
            }
        }
        return count;
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}