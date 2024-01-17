import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] num = {1, 5, 10, 50};
    static boolean[] visit;
    static int count = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 개수 입력 받기
        visit = new boolean[20 * 50 + 1];

        bruteforce();
        System.out.println(count);
    }

    private static void bruteforce() {
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n-i; j++) {
                for(int k=0; k<=n-i-j; k++) {
                    int l = n-i-j-k;
                    int sum = i * 1 + j * 5 + k * 10 + l * 50;
                    if(!visit[sum]) {
                        visit[sum] = true;
                        count++;
                    }
                }
            }
        }
    }
}
