import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited, finished;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        finished = new boolean[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            if (dfs(i, i)) {
                result.add(i + 1);
            }
        }

        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    private static boolean dfs(int start, int current) {
        if (!visited[current]) {
            visited[current] = true;
            int next = arr[current];
            if (dfs(start, next)) return true;
        } else if (current == start) {
            return true;
        }
        return false;
    }
}