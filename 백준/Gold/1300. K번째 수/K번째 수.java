import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long n;
    public static long k;
    public static long low;
    public static long high;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        low = 1;
        high = n*n;

        while(low <= high) {
            long mid = (low+high)/2;
            long count = 0;

            for(int i=1; i<=n; i++) {
                count += Math.min(n, mid / i);
            }
            if(count < k) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        System.out.println(low);
    }
}