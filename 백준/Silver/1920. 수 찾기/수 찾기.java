import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int current = Integer.parseInt(st.nextToken());
            if(set.contains(current)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}