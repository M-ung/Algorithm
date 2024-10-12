import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, K;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int count = 0;
        boolean check = false;

        for(int i=1; i <= N; i++) {
            if(N % i == 0) {
                count++;
            }
            if(count == K) {
                System.out.println(i);
                check = true;
                break;
            }
        }
        if(!check) {
            System.out.println(0);
        }
    }
}
