import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] dp = new long[n+1];
        long[] scores = new long[n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            scores[i] = Long.parseLong(st.nextToken());
        }

        if(n == 0) {
            System.out.println(0);
            return;
        }
        if(n == 1) {
            System.out.println(scores[1]);
            return;
        }
        if(n == 2) {
            System.out.println(scores[1] + scores[2]);
            return;
        }

        dp[0]=0;
        dp[1]=scores[1];
        dp[2]=scores[1] + scores[2];

        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-2] + scores[i], dp[i-3] + scores[i-1] + scores[i]);
        }

        System.out.println(dp[n]);
    }
}