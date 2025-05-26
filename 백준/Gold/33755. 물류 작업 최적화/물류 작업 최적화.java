import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        boolean minus = false;

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] < 0) {
                minus = true;
            }
        }
        if(!minus) {
            int sum = 0;
            for(int i=0; i<n; i++) {
                sum += arr[i];
            }
            for(int i=0; i<n; i++) {
                dp[i] = sum;
            }
        } else {
            for(int i=0; i<n; i++) {
                int cur = arr[i];
                int max = arr[i];
                for(int j=i+1; j<n; j++) {
                    cur += arr[j];
                    max = Math.max(max, cur);
                }
                if(i != 0) {
                    if(arr[i] < 0) {
                        dp[i] = Math.max(dp[i-1] + max, max);
                    } else {
                        dp[i] = Math.max(dp[i-1], max);
                    }
                } else {
                    dp[i] = max;
                }
            }
        }

        print();
    }

    private static void print() {
        for(int i=0; i<n; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}