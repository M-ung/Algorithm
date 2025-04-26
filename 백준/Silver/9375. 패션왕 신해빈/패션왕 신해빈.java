import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            HashMap<String ,Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String s = br.readLine();
                map.put(s.split(" ")[1], map.getOrDefault(s.split(" ")[1], 0) + 1);
            }
            int sum = 1;
            for (Integer value : map.values()) {
                sum *= (value+1);
            }
            System.out.println(sum-1);
        }

    }
}