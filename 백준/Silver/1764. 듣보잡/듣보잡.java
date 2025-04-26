import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        TreeSet<String> tree = new TreeSet<>();

        for(int i=0; i<n; i++) {
            set.add(br.readLine());
        }

        for(int i=0; i<m; i++) {
            String s = br.readLine();
            if(set.contains(s)) {
                tree.add(s);
            }
        }

        List<String> list = new ArrayList<>(tree);

        System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}