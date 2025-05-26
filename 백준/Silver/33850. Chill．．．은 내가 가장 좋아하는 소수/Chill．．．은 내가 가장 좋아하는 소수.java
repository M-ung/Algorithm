import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, a, b;
    static int[][] map;
    static boolean[] isPrime;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[2][n];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isPrime = new boolean[200_001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 200_000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 200_000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        dp = new int[n + 1];
        dp[0] = 0;

        if (n >= 1) {
            dp[1] = getScore(map[0][0], map[1][0]);
        }

        for (int i = 2; i <= n; i++) {
            int col = i - 1;
            int vertical = getScore(map[0][col], map[1][col]);
            int horizontal = getScore(map[0][col - 1], map[0][col]) + getScore(map[1][col - 1], map[1][col]);
            dp[i] = Math.max(dp[i - 1] + vertical, dp[i - 2] + horizontal);
        }

        System.out.println(dp[n]);
    }

    static int getScore(int x, int y) {
        return isPrime[x + y] ? a : b;
    }
}