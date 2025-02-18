import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        backtrack(0);
    }
    private static void backtrack(int depth) {
        if (depth == m) { 
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { 
                visited[i] = true;
                list.add(i);
                backtrack(depth + 1);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}