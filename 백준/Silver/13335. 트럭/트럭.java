import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int w;
    static int l;
    static int[] trucks;
    static int time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        trucks = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            queue.add(0);
        }
        while (index < n) {
            time++;
            int truck = queue.poll();
            if(truck != 0) {
                l += truck;
            }
            if(l >= trucks[index]) {
                l -= trucks[index];
                queue.add(trucks[index]);
                index++;
            } else {
                queue.add(0);
            }
        }
        while (!queue.isEmpty()) {
            time++;
            queue.poll();
        }
        System.out.println(time);
    }
}