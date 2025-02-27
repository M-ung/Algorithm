import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int k;
    public static long n;
    public static long[] LANs;
    public static long low;
    public static long high;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        LANs = new long[k];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            LANs[i] = Long.parseLong(st.nextToken());
        }

        low = 1;
        high = Arrays.stream(LANs).max().getAsLong();

        while(low <= high) {
            long mid = (low + high) / 2;

            long count = 0;
            for(long LAN : LANs) {
                if(LAN >= mid) {
                    count += LAN/mid;
                }
            }

            if(count < n) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}
