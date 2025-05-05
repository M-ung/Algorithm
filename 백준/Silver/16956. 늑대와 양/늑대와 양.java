import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            graph[i] = line.toCharArray();
        }

        if (!placeFences()) {
            System.out.println("0");
        } else {
            System.out.println("1");
            for (int i = 0; i < R; i++) {
                System.out.println(new String(graph[i]));
            }
        }
    }

    private static boolean placeFences() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'W') {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                        if (graph[nx][ny] == 'S') {
                            return false;
                        }

                        if (graph[nx][ny] == '.') {
                            graph[nx][ny] = 'D';
                        }
                    }
                }
            }
        }
        return true;
    }
}