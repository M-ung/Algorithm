import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean visited[];
    static int[] distance;
    static ArrayList<Edge>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());
                arr[s].add(new Edge(e,v));
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(1);
        int max = 1;
        for(int i=2; i<=N; i++) {
            if(distance[max] < distance[i]){
                max = i;
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            for(Edge i : arr[now_node]) {
                int e = i.e;
                int v = i.value;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
        }
    }
    static class Edge {
        int e;
        int value;
        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}
