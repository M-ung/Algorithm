
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int[][] arr; // 정점과 간선의 관계를 나타낼 2차원 배열
    static boolean[] check; // 이미 호출된 정점 체크
    static int count; // 감염된 컴퓨터 수
    public static void dfs(int V) { // dfs 함수
        check[V] = true; // 호출됨을 표시 true
        for(int i=1; i<=N; i++){ // 정점의 개수만큼 반복문
            if(arr[V][i] == 1 && check[i] == false) // V 정점과 연결되어 있으며, 호출이 되지 않은 정점일 경우
            {
                count ++;
                dfs(i); // dfs 호출(재귀함수)
            }
        }
    }
//    public static void bfs(int V) { // bfs 함수
//        Queue<Integer> q = new LinkedList<Integer>(); // 큐 생성
//        q.offer(V);
//        check[V] = true; // 호출됨을 표시 true
//
//        while(!q.isEmpty()) { // 빈 큐가 될 때까지 반복문
//            int cur = q.poll(); // 현재 큐에서 나온 값
//            for(int i=1; i<=N; i++) // 정점의 개수만큼 반복문
//            {
//                if(arr[cur][i] == 1 && check[i] == false) { // V 정점과 연결되어 있으며, 호출이 되지 않은 정점일 경우
//                    q.offer(i); // 큐에 삽입
//                    check[i] = true; // 호출되므로 true
//                    System.out.print(i+" "); // 출력
//                }
//            }
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 정점의 개수
        M = sc.nextInt(); // 간선의 개수
        arr = new int[N+1][N+1]; // 정점과 간선의 관계를 나타낼 2차원 배열
        check = new boolean[N+1]; // 이미 호출된 정점 체크
        count = 0; // 감염된 컴퓨터 수

        for(int i=0; i<M; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        dfs(1); // dfs 호출
        // check = new boolean[N+1]; // 초기화
        // bfs(1); // bfs 호출

        System.out.println(count); // 감염된 컴퓨터 수 출력
        sc.close();
    }
}
