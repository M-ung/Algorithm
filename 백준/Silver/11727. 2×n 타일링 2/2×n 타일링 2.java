import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}