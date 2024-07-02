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
    static ArrayList<ArrayList<Integer>> arr;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for(int i=0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        ans = new int[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.get(s).add(e);
            ans[e]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if(ans[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.println(now + " ");
            for(int next : arr.get(now)) {
                ans[next]--;
                if(ans[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
