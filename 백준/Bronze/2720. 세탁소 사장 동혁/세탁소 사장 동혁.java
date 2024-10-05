import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        int[] changes = {25, 10 , 5, 1};


        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int[] result = new int[4];

            for(int j=0; j<changes.length; j++) {
                result[j] = C/changes[j];
                C = C%changes[j];
            }

            for(int k=0; k<result.length; k++) {
                System.out.print(result[k] + " ");
            }
            System.out.println();
        }
    }
}
