import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] bridge;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        bridge = new int[n+1];
        visited = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());

        dfs(s);

        int count = 0;
        for(int i=1; i<=n; i++) {
            if(visited[i]) count++;
        }
        System.out.println(count);
    }
    private static void dfs(int index) {
        if(index <= 0 || index > n) {
            return;
        }

        visited[index] = true;

        dfs(index+bridge[index]);
        dfs(index-bridge[index]);
    }
}