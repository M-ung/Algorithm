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

        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        
        for (int i=0; i<N; i++) {
            int start_index = 0;
            int end_index = N-1;
            while(start_index < end_index) {
                if(arr[start_index] + arr[end_index] == arr[i]) {
                    if(start_index != i && end_index != i) {
                        count++;
                        break;
                    }
                    else if(start_index == i) {
                        start_index++;
                    }
                    else if(end_index == i) {
                        end_index--;
                    }
                }
                else if(arr[start_index] + arr[end_index] < arr[i]) {
                    start_index++;
                }
                else if(arr[start_index] + arr[end_index] > arr[i]) {
                    end_index--;
                }
            }
        }

        System.out.println(count);
    }
}
