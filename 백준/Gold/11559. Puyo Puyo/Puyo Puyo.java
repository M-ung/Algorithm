import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static char[][] board;
    public static int count;
    public static int[] dx = {0 , 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[12][6];
        for(int i=0; i<12; i++) {
            String s = br.readLine();
            for(int j=0; j<6; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        solve();
    }

    private static void solve() {
        while(true) {
            boolean explored = false;
            boolean[][] visited = new boolean[12][6];

            for(int i=0; i<12; i++) {
                for(int j=0; j<6; j++) {
                    if(board[i][j] != '.' && !visited[i][j]) {
                        if(bfs(i, j, visited)) {
                            explored = true;
                        }
                    }
                }
            }

            if(!explored) break;

            gravity();
            count++;
        }
        System.out.println(count);
    }

    private static void gravity() {
        for(int j=0; j<6; j++) {
            LinkedList<Character> column = new LinkedList<>();
            for(int i=11; i>=0; i--) {
                if(board[i][j] != '.') {
                    column.add(board[i][j]);
                    board[i][j] = '.';
                }
            }
            int row = 11;
            for (char c : column) {
                board[row--][j] = c;
            }
        }

    }

    private static boolean bfs(int x, int y, boolean[][] visited) {
        Queue<Puyo> queue = new LinkedList<>();
        LinkedList<Puyo> connected = new LinkedList<>();
        char color = board[x][y];

        visited[x][y] = true;
        queue.add(new Puyo(x, y, color));
        connected.add(new Puyo(x, y, color));

        while(!queue.isEmpty()) {
            Puyo puyo = queue.poll();
            for(int k=0; k<4; k++) {
                int newX = puyo.x + dx[k];
                int newY = puyo.y + dy[k];

                if(newX >= 0 && newY >= 0 && newX < 12 && newY < 6 && !visited[newX][newY] && board[newX][newY] == color) {
                    visited[newX][newY] = true;
                    queue.add(new Puyo(newX, newY, color));
                    connected.add(new Puyo(newX, newY, color));
                }
            }
        }

        if(connected.size() >= 4) {
            for(Puyo puyo : connected) {
                board[puyo.x][puyo.y] = '.';
            }
            return true;
        }
        return false;
    }

    private static class Puyo {
        int x;
        int y;
        char color;
        public Puyo(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}