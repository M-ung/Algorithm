import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int count = 1; // N 일 때를 미리 카운트하고 시작
        long sum = 1;
        long start_index = 1;
        long end_index = 1;

        while(end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum = sum + end_index;
            }
            else if (sum > N) {
                sum = sum - start_index;
                start_index++;
            }
            else {
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
