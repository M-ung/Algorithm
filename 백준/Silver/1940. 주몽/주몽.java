import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        int count = 0;
        int start_index = 0;
        int end_index = N-1;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 1. start_index + end_index == M, count++, start_index++
        // 2. start_index + end_index < M, start_index++
        // 3. start_index + end_index > M, end_index--
        // 1 2 3 4 5 7
        while(start_index < end_index) {
            if(arr[start_index] + arr[end_index] == M) {
                count++;
                start_index++;
                end_index--;
            }
            else if(arr[start_index] + arr[end_index] < M) {
                start_index++;
            }
            else if(arr[start_index] + arr[end_index] > M) {
                end_index--;
            }
        }
        System.out.println(count);

    }
}
