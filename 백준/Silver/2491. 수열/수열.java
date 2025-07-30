import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] nums = new int [n+1];
        for(int i=1; i<=n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];

        int max = 1;

        dp1[1] = 1;
        for(int i=2; i<=n; i++) {
            if(nums[i] >= nums[i-1]) {
                dp1[i] = dp1[i-1] + 1;
            } else {
                dp1[i] = 1;
            }
            max = Math.max(max, dp1[i]);
        }

        dp2[n] = 1;
        for(int i=n-1; i>0; i--) {
            if(nums[i] >= nums[i+1]) {
                dp2[i] = dp2[i+1] + 1;
            } else {
                dp2[i] = 1;
            }

            max = Math.max(max, dp2[i]);
        }

        System.out.println(max);
    }
}
