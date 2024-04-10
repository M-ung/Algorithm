import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long count;

        while(true) {
            long c;
            if(a == 0) {
                count = b;
                break;
            }
            else if(b == 0) {
                count = a;
                break;
            }
            if(a >= b) {
                c = a % b;
                a = c;
            }
            else if(b > a) {
                c = b % a;
                b = c;
            }
        }

        while(count-- > 0) {
            bw.write("1");
        }

        bw.flush();
        bw.close();
    }
}
