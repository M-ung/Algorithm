import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == -1) {
                break;
            }

            int sum = 0;
            StringBuilder divisors = new StringBuilder();

            for (int i = 1; i < N; i++) {
                if (N % i == 0) {
                    sum += i;
                    divisors.append(i).append(" + "); // 약수 추가
                }
            }

            if (sum == N) {
                divisors.setLength(divisors.length() - 3);
                bw.write(N + " = " + divisors.toString() + "\n");
            } else {
                bw.write(N + " is NOT perfect.\n");
            }

        }
        bw.flush();
        bw.close();
    }
}
