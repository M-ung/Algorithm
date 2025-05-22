import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n, l, r;
    static int count;
    static boolean isCheck= false;
    static int[][] a;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        a = new int[n][n];

        for(int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;

        while(true) {
            isCheck = false;
            visited = new boolean[n][n];
            List<List<int[]>> unions = new ArrayList<>();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!visited[i][j]) {
                        List<int[]> union = bfs(i, j);
                        if(union.size() > 1) {
                            unions.add(union);
                            isCheck = true;
                        }
                    }
                }
            }

            for(List<int[]> union : unions) {
                int sum = 0;
                for(int[] pos : union) sum += a[pos[0]][pos[1]];
                int avg = sum / union.size();
                for(int[] pos : union) a[pos[0]][pos[1]] = avg;
            }
            if (!isCheck) break;
            count++;
        }

        System.out.println(count);
    }

    private static List<int[]> bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        q.add(new int[]{i,j});
        union.add(new int[]{i,j});
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int d=0; d<4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int dif = Math.abs(a[now[0]][now[1]] - a[nx][ny]);
                    if(dif >= l && dif <= r) {
                        q.add(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return union;
    }
}