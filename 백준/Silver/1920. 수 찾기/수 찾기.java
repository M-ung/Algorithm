import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            find(target);
        }
    }
    private static void find(int num) {
        int start = 0;
        int end = arr.length - 1;
        boolean check = false;
        while(start <= end) {
            int mid = (start + end)/2;
            int midV = arr[mid];
            if(num < midV) {
                end = mid - 1;
            }
            else if(num > midV) {
                start = mid + 1;
            }
            else {
                check = true;
                break;
            }
        }
        if(check) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
