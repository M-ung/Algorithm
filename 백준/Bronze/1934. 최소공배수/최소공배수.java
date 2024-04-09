import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            calculator(a, b);
        }
    }
    public static void calculator(int a, int b) {
        int temp_a = a;
        int temp_b = b;

        while(true) {
            if(a > b) {
                b = b + temp_b;
            }
            else if(a < b) {
                a = a + temp_a;
            }
            else {
                break;
            }
        }
        System.out.println(a);
    }
}
