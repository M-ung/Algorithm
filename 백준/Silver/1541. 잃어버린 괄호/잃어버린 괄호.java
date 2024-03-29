import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String example = st.nextToken();
        String[] split = example.split("-");

        int sum = 0;

        for(int i=0; i<split.length; i++) {
            String[] temp = split[i].split("[+]");
            int tempSum = 0;
            for(int j=0; j<temp.length; j++) {
                tempSum += Integer.parseInt(temp[j]);
            }

            if(i == 0) {
                sum+=tempSum;
            }
            else {
                sum-=tempSum;
            }
        }
        System.out.println(sum);
    }
}
