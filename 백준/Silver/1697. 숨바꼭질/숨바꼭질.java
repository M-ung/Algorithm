import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100001;
    static boolean[] visited = new boolean[MAX];
    static int[] distance = new int[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n);

        System.out.println(distance[k]);
    }
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        distance[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            int[] nexts = { now - 1, now + 1, now * 2 };
            for (int next : nexts) {
                if (next >= 0 && next < MAX && !visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}