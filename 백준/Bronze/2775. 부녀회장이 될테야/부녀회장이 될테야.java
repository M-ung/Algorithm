import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] ks = new int[t];
        int[] ns = new int[t];

        int maxK = 0;
        int maxN = 0;

        int[][] inputs = new int[t][2];
        for (int i = 0; i < t; i++) {
            ks[i] = Integer.parseInt(br.readLine());
            ns[i] = Integer.parseInt(br.readLine());
            maxK = Math.max(maxK, ks[i]);
            maxN = Math.max(maxN, ns[i]);
        }

        int[][] dp = new int[maxK + 1][maxN + 1];

        for (int n = 1; n <= maxN; n++) {
            dp[0][n] = n;
        }

        for (int k = 1; k <= maxK; k++) {
            dp[k][1] = 1;
        }

        for (int k = 1; k <= maxK; k++) {
            for (int n = 2; n <= maxN; n++) {
                dp[k][n] = dp[k][n - 1] + dp[k - 1][n];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(dp[ks[i]][ns[i]]).append('\n');
        }
        System.out.print(sb);
    }
}