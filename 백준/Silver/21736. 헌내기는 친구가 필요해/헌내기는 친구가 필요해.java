import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        int startI = 0;
        int startJ = 0;

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'X') {
                    visited[i][j] = true;
                } else if (map[i][j] == 'I') {
                    startI = i;
                    startJ = j;
                }
            }
        }

        visited[startI][startJ] = true;
        bfs(startI, startJ);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        int count = 0;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for(int d=0; d<4; d++) {
                int ni = p[0] + dx[d];
                int nj = p[1] + dy[d];

                if(ni >= 0 && ni < map.length && nj >= 0 && nj < map[0].length && !visited[ni][nj]) {
                    if(map[ni][nj] == 'P') {
                        count++;
                    }
                    visited[ni][nj] = true;
                    queue.add(new int[]{ni, nj});
                }
            }
        }

        System.out.println(count == 0 ? "TT" : count);
    }
}