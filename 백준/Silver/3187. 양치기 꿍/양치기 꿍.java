import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int sheepCount = 0;
        int wolfCount = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    int[] counts = bfs(i, j);
                    if (counts[0] > counts[1]) {
                        sheepCount += counts[0];
                    } else {
                        wolfCount += counts[1];
                    }
                }
            }
        }
        System.out.println(sheepCount + " " + wolfCount);
    }
    private static int[] bfs(int startX, int startY) {
        int sheep = 0;
        int wolf = 0;

        visited[startX][startY] = true;
        if (map[startX][startY] == 'k') {
            sheep++;
        } else if (map[startX][startY] == 'v') {
            wolf++;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && map[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 'k') {
                        sheep++;
                    } else if (map[nx][ny] == 'v') {
                        wolf++;
                    }
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return new int[]{sheep, wolf};
    }
}
