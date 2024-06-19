import java.io.*;
import java.util.*;

public class Main {
    static int k, v, e;
    static boolean visited[];
    static int check[];
    static List<Integer>[] arr;
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            arr = new List[v+1];
            visited = new boolean[v+1];
            check = new int[v+1];
            isEven = true;

            for(int j = 0; j<=v; j++) {
                arr[j] = new ArrayList<>();
            }
            for(int k = 0; k < e; k++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                arr[s].add(e);
                arr[e].add(s);
            }
            for(int l=1; l<=v; l++) {
                if(isEven) {
                    DFS(l);
                }
                else {
                    break;
                }
            }
            if(isEven) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }

        }
    }
    private static void DFS(int node) {
        visited[node] = true;
        for(int i : arr[node]) {
            if(!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            else if(check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}
