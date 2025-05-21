import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n, m;
    static int maxSafe = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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
        build(0);
        System.out.println(maxSafe);
    }

    private static void build(int count) {
        if (count == 3) {
            int[][] copyMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, m);
            }
            spreadVirus(copyMap);
            maxSafe = Math.max(maxSafe, countSafeArea(copyMap));
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    build(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus(int[][] copyMap) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
    
    private static int countSafeArea(int[][] copyMap) {
        int safeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    safeCount++;
                }
            }
        }
        return safeCount;
    }
}