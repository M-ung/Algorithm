import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());

        int count = 1;
        int range = 2;

        if(target == 1) {
            System.out.println(1);
        }
        else {
            while(range <= target) {
                range = range + (6 * count);
                count++;
            }
            System.out.println(count);
        }
    }
}
