import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static int[][] members;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        members = new int[n][n];
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                members[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack( 0, 0);
        System.out.println(min);
    }

    private static void backtrack(int depth, int start) {
        if (depth == n / 2) {
            calculate();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;  
                backtrack(depth + 1, i + 1);
                visited[i] = false; 
            }
        }
    }

    private static void calculate() {
        int team1 = 0, team2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    team1 += members[i][j] + members[j][i];
                } else if (!visited[i] && !visited[j]) {
                    team2 += members[i][j] + members[j][i]; 
                }
            }
        }
        min = Math.min(min, Math.abs(team1 - team2));
    }
}
