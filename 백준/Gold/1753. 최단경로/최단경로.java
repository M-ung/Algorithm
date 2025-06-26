import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static int k;
    static List<Weight>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        graph = new List[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Weight(v, w));
        }

        int[] distance = dijkstra(k);

        for (int i = 1;  i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static int[] dijkstra(int start) {
        int[] distance = new int[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Weight> queue = new PriorityQueue<>(Comparator.comparingInt(Weight::getW));
        queue.add(new Weight(start, 0));

        while(!queue.isEmpty()) {
            Weight currentWeight = queue.poll();
            int currentV = currentWeight.getV();
            int currentW = currentWeight.getW();

            if(distance[currentV] < currentW) continue;

            for(Weight next : graph[currentV]) {
                int nextDist = currentW + next.getW();
                if(nextDist < distance[next.getV()]) {
                    distance[next.getV()] = nextDist;
                    queue.add(new Weight(next.v, nextDist));
                }
            }
        }
        return distance;
    }

    static class Weight {
        private int v;
        private int w;

        public Weight(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int getV() {
            return v;
        }

        public int getW() {
            return w;
        }
    }
}
