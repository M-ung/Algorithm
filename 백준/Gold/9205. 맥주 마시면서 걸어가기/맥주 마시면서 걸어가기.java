import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] locations = new int[n+2][2];

            for(int j=0; j<n+2; j++) {
                st = new StringTokenizer(br.readLine());
                locations[j][0] = Integer.parseInt(st.nextToken());
                locations[j][1] = Integer.parseInt(st.nextToken());
            }

            if (bfs(locations)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static boolean bfs(int[][] locations) {
        int n = locations.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == n - 1) return true;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && distance(locations[curr], locations[i]) <= 1000) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return false;
    }

    private static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}