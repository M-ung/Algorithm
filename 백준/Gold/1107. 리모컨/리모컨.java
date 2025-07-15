import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[] buttons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        buttons = new boolean[10];

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int broken = Integer.parseInt(st.nextToken());
                buttons[broken] = true;
            }
        }

        int min = Math.abs(n - 100); 

        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean possible = true;

            for (int j = 0; j < str.length(); j++) {
                if (buttons[str.charAt(j) - '0']) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                int pressCount = str.length();
                int moveCount = Math.abs(n - i);
                min = Math.min(min, pressCount + moveCount);
            }
        }

        System.out.println(min);
    }
}
