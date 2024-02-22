import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] result = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        int value = 0;
        int sum = 0;
        for(int i=0; i<N; i++) {
            value += arr[i];
            result[i] = value;
        }

        for(int i=0; i<N; i++) {
            sum += result[i];
        }

        System.out.println(sum);
    }
}
