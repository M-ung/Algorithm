import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] arr;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }
        for(int i=0; i<N; i++) {
            DFS(i,1);
            if(arrive)
                break;
        }
        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");
    }
    public static void DFS(int now, int depth) {
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i : arr[now]) {
            if(!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}