import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        int[] arr = new int[str.length()];

        for(int i=0; i<str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for(int i=0; i<arr.length; i++) {
            int max = -999;
            int max_index = 0;
            for(int j=i; j< arr.length; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    max_index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[max_index];
            arr[max_index] = tmp;
        }

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
