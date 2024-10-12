import java.util.*;
import java.io.*;

public class Main {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a, b;

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        while(a != 0 && b !=0) {
            if(b%a==0) {
                System.out.println("factor");
            }
            else if(a%b==0) {
                System.out.println("multiple");
            }
            else {
                System.out.println("neither");
            }

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }
    }
}
