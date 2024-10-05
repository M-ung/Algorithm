import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<Character> arrayList = new ArrayList<>();

        while(N>0) {
            if(N % B < 10) {
                arrayList.add((char) (N % B + '0'));
            } else {
                arrayList.add((char) (N % B - 10 + 'A'));
            }
            N /= B;
        }

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            System.out.print(arrayList.get(i));
        }
    }
}
