import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Food[] foods;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        foods = new Food[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            foods[i] = new Food(s, b);
        }

        int subsetCount = 1 << n; 

        for (int mask = 1; mask < subsetCount; mask++) { 
            int mul_s = 1;
            int sum_b = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { 
                    mul_s *= foods[i].s;
                    sum_b += foods[i].b;
                }
            }

            min = Math.min(min, Math.abs(mul_s - sum_b));
        }

        System.out.println(min);
    }

    static class Food {
        int s, b;
        public Food(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
}