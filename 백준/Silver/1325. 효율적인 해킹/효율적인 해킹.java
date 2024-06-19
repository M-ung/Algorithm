import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static boolean visited[];
    static int ans[];
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new List[n+1];
        ans = new int[n+1];

        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

        for(int i=1; i<=n; i++) {
            visited = new boolean[n+1]; // 방문 배열 초기화
            BFS(i);
        }
        int max = 0;

        for (int i=1; i<=n; i++) {
            max = Math.max(max, ans[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (ans[i] == max) {		// 최대값과 같다면 인덱스 출력
                System.out.print(i + " ");
            }
        }
    }
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for(int i : graph[now_node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    ans[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
