import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(start < arr[i]) {
                start = arr[i];
            }
            end += arr[i];
        }
        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for(int i=0; i<N; i++) {
                if(sum + arr[i] > mid) {
                    count++;
                    sum=0;
                }
                sum = sum + arr[i];
            }
            if(sum != 0) {
                count++;
            }
            if(count > M) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
