import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n<2) {
            System.out.println(dp[n]);
            return;
        }
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}