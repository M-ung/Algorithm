import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[10000001];

        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(arr.length); i++) {
            if(arr[i] == 0) {
                continue;
            }
            for(int j = i + i; j < arr.length; j = j+i) {
                arr[j] = 0;
            }
        }
        
        for(int i=N; i<=arr.length; i++) {
            String str = Long.toString(arr[i]);
            int start_index = 0;
            int end_index = str.length() - 1;
            boolean check = true;

            if(!str.equals("0")) {
                while(start_index < end_index) {
                    if(str.charAt(end_index) != str.charAt(start_index)) {
                        check = false;
                    }
                    start_index++;
                    end_index--;
                }

                if(check == true) {
                    System.out.println(str);
                    break;
                }
            }
        }
    }
}
