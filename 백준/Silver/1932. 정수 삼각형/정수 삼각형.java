import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] triangle;
    static Integer[][] dp; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        triangle = new int[n][n];
        dp = new Integer[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int i, int j) {
        if (i == n - 1) {
            return triangle[i][j];
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int left = dfs(i + 1, j);
        int right = dfs(i + 1, j + 1);

        dp[i][j] = triangle[i][j] + Math.max(left, right);
        return dp[i][j];
    }
}