
import java.util.*;

public class Main{
    static int T, N, M, K;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y){
        map[x][y] = 0;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==1)
                dfs(nx, ny);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt(); // 테스트 개수
        for(int i=0; i<T; i++)
        {
            N = sc.nextInt(); // 세로 개수
            M = sc.nextInt(); // 가로 개수
            K = sc.nextInt(); // 배추 위치 개수
            map = new int[N][M];
            for(int j=0; j<K; j++)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            int result = 0;
            for(int k=0; k<N; k++){
                for(int l=0; l<M; l++){
                    if(map[k][l] == 1){
                        dfs(k,l);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }


    }
}