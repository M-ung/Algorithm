import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] arr; // 정점과 간선의 관계를 나타낼 2차원 배열
    static boolean[] check; // 이미 호출된 정점 체크
    static int count;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1][N+1]; // 정점과 간선의 관계를 나타낼 2차원 배열
        check = new boolean[N+1]; // 이미 호출된 정점 체크
        count = 0;

        for(int i=1; i<=M; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        for(int i=1; i<=N; i++)
        {
            if(!check[i]) // V 정점과 연결되어 있으며, 호출이 되지 않은 정점일 경우
            {
                count++;
                dfs(i); // dfs 호출(재귀함수)
            }
        }
        System.out.println(count);
        sc.close();
    }
    public static void dfs(int V) { // dfs 함수
        check[V] = true;
        for(int i = 1; i <= N; i++) {
            if(check[i] == false && arr[V][i] == 1) {
                dfs(i);
            }
        }
    }
}
