import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] commands = br.readLine().toCharArray();

        int dir = 0;
        int x = 0, y = 0;
        int minX = 0, maxX = 0, minY = 0, maxY = 0;

        List<int[]> path = new ArrayList<>();
        path.add(new int[]{x, y});

        for (char command : commands) {
            if (command == 'L') { // 남 -> 동 -> 북 -> 서
                dir = (dir + 3) % 4;
            } else if (command == 'R') { // 남 -> 서 -> 북 -> 동
                dir = (dir + 1) % 4;
            } else if (command == 'F') {
                x += dx[dir];
                y += dy[dir];
                path.add(new int[]{x, y});

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
        }

        int height = maxX - minX + 1;
        int width = maxY - minY + 1;

        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = '#';
            }
        }

        for (int[] p : path) {
            int realX = p[0] - minX;
            int realY = p[1] - minY;
            map[realX][realY] = '.';
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}