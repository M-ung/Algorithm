import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for(int i=0; i<n; i++) {
            sum += arr[i];

            while(sum >= s) {
                minLength = Math.min(minLength, i - start + 1);
                sum -= arr[start++];
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
