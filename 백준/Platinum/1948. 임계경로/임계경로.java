import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<ArrayList<Node>> reverse_graph;
    static int[] degree;
    static int[] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverse_graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
            reverse_graph.add(new ArrayList<Node>());
        }

        int[] degree = new int[n + 1];
        int[] path = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, e));
            degree[b]++;
            reverse_graph.get(b).add(new Node(a, e));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node cur : graph.get(now)) {
                degree[cur.toNode]--;
                path[cur.toNode] = Math.max(path[cur.toNode], path[now] + cur.e);
                if (degree[cur.toNode] == 0)
                    q.offer(cur.toNode);
            }
        }

        q.offer(end);
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        visited[end] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node cur : reverse_graph.get(now)) {
                if (path[now] == path[cur.toNode] + cur.e) {
                    cnt++;
                    if (!visited[cur.toNode]) {
                        q.offer(cur.toNode);
                        visited[cur.toNode] = true;
                    }
                }
            }
        }
        System.out.println(path[end]);
        System.out.println(cnt);
    }
    static class Node {
        int toNode;
        int e;

        public Node(int toNode, int e) {
            this.toNode = toNode;
            this.e = e;
        }
    }
}
