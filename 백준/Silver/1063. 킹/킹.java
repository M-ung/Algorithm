import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // B T LT, LB, RB, RT, L, R
    static int[] dx = {-1, 1, 1, -1, -1, 1, 0, 0};
    static int[] dy = {0, 0, -1, -1, 1, 1, -1, 1};
    int[][] map = new int[8][8];
    static Chess King;
    static Chess Stone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        King = new Chess(king.charAt(1) - '0', king.charAt(0) - 'A' + 1);
        Stone = new Chess(stone.charAt(1) - '0', stone.charAt(0) - 'A' + 1);

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            command(s);
        }

        System.out.println((char)('A' + King.y - 1) + "" + King.x);
        System.out.println((char)('A' + Stone.y - 1) + "" + Stone.x);
    }

    private static void command(String s) {
        if(s.equals("R")) {
            King.move(dx[7], dy[7]);
        } else if (s.equals("L")) {
            King.move(dx[6], dy[6]);
        } else if (s.equals("B")) {
            King.move(dx[0], dy[0]);
        } else if (s.equals("T")) {
            King.move(dx[1], dy[1]);
        } else if (s.equals("RT")) {
            King.move(dx[5], dy[5]);
        } else if (s.equals("LT")) {
            King.move(dx[2], dy[2]);
        } else if (s.equals("RB")) {
            King.move(dx[4], dy[4]);
        } else if (s.equals("LB")) {
            King.move(dx[3], dy[3]);
        }
    }

    static class Chess {
        int x;
        int y;

        Chess(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int dx, int dy) {
            int nx = this.x + dx;
            int ny = this.y + dy;

            if (nx < 1 || ny < 1 || nx > 8 || ny > 8) return;

            if (nx == Stone.x && ny == Stone.y) {
                int nsx = Stone.x + dx;
                int nsy = Stone.y + dy;

                if (nsx < 1 || nsy < 1 || nsx > 8 || nsy > 8) return;
                Stone.x = nsx;
                Stone.y = nsy;
            }

            this.x = nx;
            this.y = ny;
        }
    }
}