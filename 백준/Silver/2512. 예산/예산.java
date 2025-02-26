import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static long m;
    public static long[] budgets;
    public static long low;
    public static long high;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        budgets = new long[n];
        for(int i=0; i<n; i++) {
            budgets[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        m = Long.parseLong(st.nextToken());

        low = 1;
        high = Arrays.stream(budgets).max().orElse(0);

        while(low <= high) {
            long mid = (low + high) / 2;

            long sum = 0;
            for(long budget : budgets) {
                if(budget > mid) {
                    sum += mid;
                } else {
                    sum += budget;
                }
            }

            if (sum <= m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}
