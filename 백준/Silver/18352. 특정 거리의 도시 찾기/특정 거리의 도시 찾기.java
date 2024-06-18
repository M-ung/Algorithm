import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k,x;
    static int visited[];
    static ArrayList<Integer>[] graph;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1]; // 그래프 데이터 저장
        ans = new ArrayList<>(); // 정답

        for (int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>(); // 그래프 리스트의 ArrayList 초기화
            // 노드 개수만큼 ArrayList 생성
        }

        for (int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

        visited = new int[n+1]; // 방문 배열 초기화

        for(int i=0; i<=n; i++){
            visited[i] = -1;
            // 방문 배열을 만듦
        }

        BFS(x);

        for(int i=0; i<=n; i++) {
            if(visited[i] == k) {
                ans.add(i);
            }
        }

        if(ans.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(ans);
            for(int i=0; i< ans.size(); i++) {
                System.out.println(ans.get(i));
            }
        }
        
    }
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node]++;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for(int i : graph[now_node]) {
                if(visited[i] == -1) {
                    visited[i] = visited[now_node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
