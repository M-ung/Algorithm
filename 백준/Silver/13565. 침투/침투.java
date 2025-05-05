import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean success;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            String s = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int  j=0; j<n; j++) {
            if(map[0][j] == 0 && !visited[0][j]) {
                bfs(0, j);
                if(success) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int k=0; k<4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && !visited[nx][ny] && map[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    if(nx == map.length - 1) {
                        success = true;
                    }
                }
            }
        }
    }
}