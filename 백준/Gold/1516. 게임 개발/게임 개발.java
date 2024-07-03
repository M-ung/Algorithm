import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] count;
    static int[] time;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for(int i=0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        count = new int[n+1];
        time = new int[n+1];
        ans = new int[n+1];

        for(int i=1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) {
                    break;
                }
                arr.get(e).add(i);
                count[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if(count[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int next : arr.get(now)) {
                count[next]--;
                ans[next] = Math.max(ans[next], ans[now] + time[now]);
                if(count[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for(int i=1; i<=n; i++) {
            System.out.println(ans[i] + time[i]);
        }
    }
}
