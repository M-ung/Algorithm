import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int bit = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                bit |= (1 << (x - 1));
            } else if (cmd.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                bit &= ~(1 << (x - 1));
            } else if (cmd.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append((bit & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
            } else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                bit ^= (1 << (x - 1));
            } else if (cmd.equals("all")) {
                bit = (1 << 20) - 1;
            } else if (cmd.equals("empty")) {
                bit = 0;
            }
        }
        System.out.print(sb);
    }
}