import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 개수 입력 받기

        int[] array = new int[N+1]; // 배열
        int[] dp = new int[N+1]; // DP

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // dp 초기화
        }

        int resultMax = 1;
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<i; j++) {
                if(array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            resultMax = Math.max(dp[i], resultMax);
        }
        System.out.println(resultMax);
    }
}
