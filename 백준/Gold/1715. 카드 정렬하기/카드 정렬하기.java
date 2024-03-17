import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            pq.add(data);
        }

        int data1 = 0;
        int data2 = 0;
        int sum = 0;

        while(pq.size() != 1) {
            data1 = pq.remove();
            data2 = pq.remove();

            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);
    }
}
