import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static String s;
    public static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String schedule = br.readLine();
        int s = Integer.parseInt(schedule.split(" ")[0].replace(":", ""));
        int e = Integer.parseInt(schedule.split(" ")[1].replace(":", ""));
        int q = Integer.parseInt(schedule.split(" ")[2].replace(":", ""));

        HashSet<String> open = new HashSet<>();
        HashSet<String> closed = new HashSet<>();

        String input;
        while ((input = br.readLine()) != null) {
            int time = Integer.parseInt(input.split(" ")[0].replace(":", ""));
            String name = input.split(" ")[1];

            if(time <= s) {
                open.add(name);
            } else if (time >= e && time <= q) {
                closed.add(name);
            }
        }
        int count = 0;
        for (String name : closed) {
            if (open.contains(name)) {
                count++;
            }
        }

        System.out.println(count);
    }
}