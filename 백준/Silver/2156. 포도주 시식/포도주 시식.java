import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] wine;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        wine = new int[n];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            wine[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][1] = wine[0];
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = dp[i - 1][0] + wine[i];
            dp[i][2] = dp[i - 1][1] + wine[i];
        }

        int result = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(result);
    }
}