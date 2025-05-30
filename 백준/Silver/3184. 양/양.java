import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];
        int wolfCount = 0;
        int sheepCount = 0;

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'v') {
                    wolfCount++;
                } else if (map[i][j] == 'o') {
                    sheepCount++;
                }
            }
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(map[i][j] == '#' || visited[i][j]) continue;
                int[] counts = bfs(i, j);
                if (counts[1] > counts[0]) {
                    wolfCount -= counts[0];
                } else {
                    sheepCount -= counts[1]; 
                }
            }
        }

        System.out.println(sheepCount + " " + wolfCount);
    }

    private static int[] bfs(int i, int j) {
        int wolfCount = 0;
        int sheepCount = 0;
        visited[i][j] = true;

        Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{i, j});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if(map[x][y] == 'v') {
                wolfCount++;
            } else if(map[x][y] == 'o') {
                sheepCount++;
            }

            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == '#' || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }

        return new int[]{wolfCount, sheepCount};
    }
}