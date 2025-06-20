import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> graph;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        result = new int[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1) break;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            result[i] = bfs(i);
            min = Math.min(result[i], min);
        }

        List<Integer> members = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(result[i] == min) {
                members.add(i);
            }
        }

        System.out.println(min + " " + members.size());
        for(int member : members) {
            System.out.print(member + " ");
        }
    }

    private static int bfs(int start) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n+1];

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                    q.add(next);
                }
            }
        }

        int maxDist = 0;
        for(int d : dist) {
            maxDist = Math.max(maxDist, d);
        }
        return maxDist;
    }
}
