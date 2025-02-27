import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static long c;
    public static long[] xs;
    public static long low;
    public static long high;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        xs = new long[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            xs[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(xs);

        low = 1;
        high = Arrays.stream(xs).max().getAsLong() - Arrays.stream(xs).min().getAsLong();

        while(low <= high) {
            long mid = (low + high) / 2;

            int count = 1;
            long current = xs[0] + mid;
            for(int i=1; i<n; i++) {
                long now = xs[i];
                if(now >= current) {
                    count++;
                    current = now + mid;
                }
            }

            if(count < c) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}
