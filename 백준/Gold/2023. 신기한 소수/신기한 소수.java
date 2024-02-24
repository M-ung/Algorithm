import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int number, int index) {
        if(index == N) {
            if(isPrime(number)) {
                System.out.println(number);
            }
            return;
        }
        for(int i = 1; i<10; i++) {
            if(i % 2 == 0) {
                continue;
            }
            if(isPrime(number * 10 + i)) {
                DFS(number * 10 + i, index + 1);
            }
        }
    }
    static boolean isPrime(int number) {
        for(int i=2; i<=number/2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
