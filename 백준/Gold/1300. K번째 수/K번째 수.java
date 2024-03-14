import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        long start = 1;
        long end = K;

        while(start < end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for(int i=1; i<=N; i++) {
                cnt += Math.min(mid/i, N);
            }

            if(K <= cnt) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}