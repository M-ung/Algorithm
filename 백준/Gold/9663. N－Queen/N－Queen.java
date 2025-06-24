import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int result = 0;
    static int[] col;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        col = new int[n];
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int row) {
        if (row == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(row, i)) {
                col[row] = i;
                dfs(row + 1);
            }
        }
    }

    private static boolean isSafe(int r, int c) {
        for(int i=0; i<r; i++) {
            if(col[i] == c) return false;
            if(Math.abs(r-i) == Math.abs(c-col[i])) return false;
        }
        return true;
    }
}