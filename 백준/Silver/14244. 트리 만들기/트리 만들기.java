import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n-1; i++)
        {
            if (i < n - m)
            {
                System.out.println(i+" "+(i+1));
            }

            else
            {
                System.out.println((n-m)+" "+(i+1));
            }
        }
    }
}
