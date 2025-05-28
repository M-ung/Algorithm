import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int year = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            int ice = bfs();
            year++;

            if (ice == 0) {
                System.out.println(0);
                return;
            }
            if (ice >= 2) {
                System.out.println(year);
                return;
            }
        }
    }

    private static int bfs() {
        int[][] mapCopy = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                mapCopy[i][j] = map[i][j];
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] > 0) {
                    int count = 0;
                    for(int d=0; d<4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                            count++;
                        }
                    }
                    mapCopy[i][j] = Math.max(0, map[i][j] - count);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = mapCopy[i][j];
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int ice = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for(int d=0; d<4; d++) {
                            int nx = current[0] + dx[d];
                            int ny = current[1] + dy[d];
                            if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] > 0 && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    ice++;
                }
            }
        }
        return ice;
    }
}