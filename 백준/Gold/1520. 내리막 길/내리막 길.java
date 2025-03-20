import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long[][] dp;
    public static long[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new long[n][m];
        dp = new long[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Long.parseLong(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }
    private static long dfs(int i, int j) {
        if (i == map.length - 1 && j == map[0].length - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = 0;

        if (i - 1 >= 0 && map[i - 1][j] < map[i][j]) {
            dp[i][j] += dfs(i - 1, j);
        }
        if (i + 1 < map.length && map[i + 1][j] < map[i][j]) {
            dp[i][j] += dfs(i + 1, j);
        }
        if (j - 1 >= 0 && map[i][j - 1] < map[i][j]) {
            dp[i][j] += dfs(i, j - 1);
        }
        if (j + 1 < map[0].length && map[i][j + 1] < map[i][j]) {
            dp[i][j] += dfs(i, j + 1);
        }
        return dp[i][j];
    }
}
