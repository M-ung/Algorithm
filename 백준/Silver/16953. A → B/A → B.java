import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static boolean check = false;
    static long a;
    static long b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        dfs(a, 1);

        if(check) {
            System.out.println(min);
        } else {
            System.out.println("-1");
        }
    }

    private static void dfs(long current, int count) {
        if(current == b) {
            min = Math.min(min, count);
            check = true;
            return;
        }
        if(current > b) {
            return;
        }

        dfs(current*2, count+1);
        dfs(current*10 + 1, count+1);
    }
}