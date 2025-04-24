import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static char[][] map;
    public static int[][] dist;
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, -1, 0, 1 };
    public static int start_x;
    public static int start_y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        dist = new int[r][c];
        
        for(int i=0; i<r; i++) {
            String s = br.readLine();
            for(int j=0; j<c; j++) {
                char ch = s.charAt(j);
                if(ch == 'S') {
                    start_x = i;
                    start_y = j;
                }
                map[i][j] = ch;
            }
        }
        bfs();
    }
    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] == '*') {
                    queue.offer(new Point(i,j,'*'));
                }
            }
        }

        dist[start_x][start_y] = 1;
        queue.offer(new Point(start_x, start_y, 'S'));

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int k=0; k<4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;

                if(p.c == '*') {
                    if(map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        queue.offer(new Point(nx, ny, '*'));
                    }
                }

                else if (p.c == 'S') {
                    if ((map[nx][ny] == '.' || map[nx][ny] == 'D') && dist[nx][ny] == 0) {
                        dist[nx][ny] = dist[p.x][p.y] + 1;
                        if (map[nx][ny] == 'D') {
                            System.out.println(dist[nx][ny] - 1);
                            return;
                        }
                        queue.offer(new Point(nx, ny, 'S'));
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }
    public static class Point {
        int x;
        int y;
        char c;
        public Point(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}