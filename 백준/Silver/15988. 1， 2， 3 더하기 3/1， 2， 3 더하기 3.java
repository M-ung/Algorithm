import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int max = 0;
        int[] inputs = new int[t];

        for (int i = 0; i < t; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            if (inputs[i] > max) {
                max = inputs[i];
            }
        }

        long[] dp = new long[max + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (max >= 2) dp[2] = 2;

        for (int i = 3; i <= max; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(dp[inputs[i]]);
        }
    }
}