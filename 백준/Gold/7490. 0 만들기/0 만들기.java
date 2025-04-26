import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static List<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            answer = new ArrayList<>();

            dfs(1, "1");

            for (String s : answer) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    private static void dfs(int num, String expr) {
        if (num == n) {
            if (calc(expr) == 0) {
                answer.add(expr);
            }
            return;
        }
        dfs(num + 1, expr + " " + (num + 1));
        dfs(num + 1, expr + "+" + (num + 1));
        dfs(num + 1, expr + "-" + (num + 1));
    }

    private static int calc(String expr) {
        expr = expr.replace(" ", "");
        int sum = 0;
        int num = 0;
        char op = '+';
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                if (op == '+') sum += num;
                else if (op == '-') sum -= num;
                op = c;
                num = 0;
            }
        }
        if (op == '+') sum += num;
        else if (op == '-') sum -= num;
        return sum;
    }
}