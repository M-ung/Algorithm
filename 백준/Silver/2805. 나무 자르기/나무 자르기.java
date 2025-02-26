import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static long m;
    public static long[] trees;
    public static long low;
    public static long high;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }

        low = 1;
        high = Arrays.stream(trees).max().orElse(0);

        while(low <= high) {
            long mid = (high + low) / 2;

            long left = 0;
            for (long tree : trees) {
                if (tree >= mid) {
                    left += (tree - mid);
                }
            }

            if (left < m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}