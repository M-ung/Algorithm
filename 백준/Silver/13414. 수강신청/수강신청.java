import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());


        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(map.containsKey(s)) {
                map.remove(s);
                map.put(s, i);
            } else {
                map.put(s, i);
            }
        }

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(k)
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}