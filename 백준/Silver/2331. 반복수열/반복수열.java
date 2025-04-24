import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int p;
    public static int count;
    public static List<Integer> visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        visited = new ArrayList<>();
        count = 0;
        start(a);
        System.out.println(count);
    }

    private static void start(int num) {
        if(visited.contains(num)) {
            count = visited.indexOf(num);
            return;
        }
        visited.add(num);
        int newNum = powEachDigit(num, p);
        start(newNum);
    }
    private static int powEachDigit(int a, int p) {
        int sum = 0;
        while (a > 0) {
            int digit = a % 10;
            sum += Math.pow(digit, p);
            a /= 10;
        }
        return sum;
    }
}