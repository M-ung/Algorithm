import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int count = 0;
        int i = 0;

        while (i < M - 1) {
            if (S.charAt(i) == 'I') {
                int cnt = 0;
                while (i + 2 < M && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                    cnt++;
                    i += 2;
                    if (cnt >= N) {
                        count++;
                    }
                }
            }
            i++;
        }
        System.out.println(count);
    }
}