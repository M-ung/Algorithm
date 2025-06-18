import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int s, x, y;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        List<Virus> virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    virusList.add(new Virus(map[i][j], i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        Collections.sort(virusList);
        Queue<Virus> queue = new LinkedList<>(virusList);

        bfs(queue);

        System.out.println(map[x - 1][y - 1]);

    }

    private static void bfs(Queue<Virus> queue) {
        while (!queue.isEmpty()) {
            Virus v = queue.poll();

            if (v.time == s) return;

            for (int d = 0; d < 4; d++) {
                int nx = v.x + dx[d];
                int ny = v.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 0) {
                    map[nx][ny] = v.type;
                    queue.offer(new Virus(v.type, nx, ny, v.time + 1));
                }
            }
        }
    }

    static class Virus implements Comparable<Virus> {
        int type, x, y, time;

        public Virus(int type, int x, int y, int time) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            return this.type - o.type;
        }
    }
}