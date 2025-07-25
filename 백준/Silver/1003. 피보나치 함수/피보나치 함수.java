import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int[] cases = new int[t];

        int max = -999;

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            cases[i] = Integer.parseInt(st.nextToken());
            max = Math.max(cases[i], max);
        }

        Result[] dp = new Result[max + 1];
        dp[0] = new Result(1, 0);

        if (max >= 1) {
            dp[1] = new Result(0, 1);
        }

        for (int i = 2; i <= max; i++) {
            int zero = dp[i - 1].getZero() + dp[i - 2].getZero();
            int one = dp[i - 1].getOne() + dp[i - 2].getOne();
            dp[i] = new Result(zero, one);
        }

        for (int i = 0; i < t; i++) {
            Result r = dp[cases[i]];
            System.out.println(r.getZero() + " " + r.getOne());
        }
    }

    static class Result {
        private final int zero;
        private final int one;

        public Result(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public int getZero() {
            return zero;
        }

        public int getOne() {
            return one;
        }
    }
}
