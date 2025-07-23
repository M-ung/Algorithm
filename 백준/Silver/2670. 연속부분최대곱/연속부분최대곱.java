import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static double[] arr;
    static double[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new double[n];
        dp = new double[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Double.parseDouble(st.nextToken());
        }

        dp[0] = arr[0];
        double max = dp[0];


        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
            max = Math.max(max, dp[i]);
        }
        
        System.out.printf("%.3f\n", max);
    }
}