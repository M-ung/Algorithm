import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static long m;
    public static long[] weeks;
    public static long low;
    public static long high;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        weeks = new long[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            weeks[i] = Long.parseLong(st.nextToken());
        }

        low = Arrays.stream(weeks).max().orElse(0);
        high = Arrays.stream(weeks).sum();

        while(low <= high) {
            long mid = (high + low) / 2;

            long money = 0;
            int count = 0;
            for(long week : weeks) {
                if(money < week) {
                    money = mid;
                    count++;
                }
                money -= week;
            }

            if (count > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
    }
}