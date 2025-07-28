import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        long[] A = new long[k + 1];
        long[] B = new long[k + 1];

        A[0] = 1;
        B[0] = 0;

        for (int i = 1; i <= k; i++) {
            A[i] = B[i - 1];
            B[i] = A[i - 1] + B[i - 1];
        }

        System.out.println(A[k] + " " + B[k]);
    }
}