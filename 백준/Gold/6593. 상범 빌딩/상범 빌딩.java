import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l, r, c;
    static int startL, startR, startC;
    static char[][][] buildings;
    static boolean[][][] visited;
    static int[] dl = {0, 0, 0, 0, 1, -1};
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null || line.isBlank()) continue;

            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

            buildings = new char[l][r][c];
            visited = new boolean[l][r][c];

             for(int i=0; i<l; i++) {
                 for(int j=0; j<r; j++) {
                     String floorLine = br.readLine();

                     while (floorLine == null || floorLine.isBlank()) {
                         floorLine = br.readLine();
                     }

                     for (int k = 0; k < c; k++) {
                         char ch = floorLine.charAt(k);
                         buildings[i][j][k] = ch;

                         if (ch == 'S') {
                             startL = i;
                             startR = j;
                             startC = k;
                         } else if (ch == '#') {
                             visited[i][j][k] = true;
                         }
                     }
                 }
                 if (i != l - 1) br.readLine();
             }
            int minute = bfs(startL, startR, startC);
             if(minute == -1) {
                 System.out.println("Trapped!");
             } else {
                 System.out.println("Escaped in " + minute + " minute(s).");
             }
        }
    }

    private static int bfs(int startL, int startR, int startC) {
        int minute = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startL, startR, startC});
        visited[startL][startR][startC] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int[] q = queue.poll();
                for (int i = 0; i < 6; i++) {
                    int nL = q[0] + dl[i];
                    int nR = q[1] + dr[i];
                    int nC = q[2] + dc[i];

                    if (nL >= 0 && nL < l && nR >= 0 && nR < r && nC >= 0 && nC < c
                            && !visited[nL][nR][nC] && buildings[nL][nR][nC] != '#') {
                        if (buildings[nL][nR][nC] == 'E') {
                            return minute + 1;
                        }

                        queue.add(new int[]{nL, nR, nC});
                        visited[nL][nR][nC] = true;
                    }
                }
            }
            minute++;
        }

        return -1;
    }
}