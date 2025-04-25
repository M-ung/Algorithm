import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int min = Integer.MAX_VALUE;
    public static int n;
    public static Food[] foods;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        foods = new Food[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            foods[i] = new Food(s, b);
        }

        for(int i = 0; i < n; i++) {
            dfs(1, 0, false, i);
        }
        System.out.println(min);
    }

    private static void dfs(int mul_s, int sum_b, boolean check, int index) {
        if(check) {
            min = Math.min(min, Math.abs(sum_b - mul_s));
        }

        for(int i=index; i<n; i++) {
            dfs(foods[i].s * mul_s, foods[i].b + sum_b, true, i+1);
        }
    }

    public static class Food {
        int s;
        int b;
        public Food(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
}
