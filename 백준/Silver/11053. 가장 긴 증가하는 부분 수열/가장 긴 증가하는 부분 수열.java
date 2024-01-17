import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 개수 입력 받기

        int[] array = new int[N+1]; // 배열
        int[] dp = new int[N+1]; // DP

        for(int i=1; i<N+1; i++) {
            array[i] = sc.nextInt();
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