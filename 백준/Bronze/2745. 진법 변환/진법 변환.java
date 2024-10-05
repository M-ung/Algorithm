import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int tmp = 1;
        int result = 0;

        for (int i = N.length() - 1; i >= 0; i--) {
            char c = N.charAt(i);
            if(c >= 'A' && c<= 'Z') {
                result += (c-55)*tmp;
            }else {
                result += (c-48)*tmp;
            }
            tmp *= B;
        }
        System.out.println(result);
    }
}