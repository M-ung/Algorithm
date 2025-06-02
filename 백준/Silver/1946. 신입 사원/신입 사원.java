import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i=0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] candidates = new int[n][2];

            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                candidates[j][0] = Integer.parseInt(st.nextToken());
                candidates[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(candidates, (a, b) -> a[0] - b[0]);
            int count = 1;
            int min = candidates[0][1];
            for(int j = 1; j < n; j++) {
                if(candidates[j][1] < min) {
                    count++;
                    min = candidates[j][1];
                }
            }
            System.out.println(count);
        }
    }
}
