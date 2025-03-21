import java.util.*;

class Solution {
    public static int distance = 999;
    public static boolean[][] visited;
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        bfs(0, 0, 1, maps);
        if(distance == 999) distance = -1;
        return distance;
    }
    private static void bfs(int i, int j, int count, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, count});  
        visited[i][j] = true; 
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            if (x == maps.length - 1 && y == maps[0].length - 1) {
                distance = Math.min(distance, dist); 
                return;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                

                if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true; 
                    queue.offer(new int[]{nx, ny, dist + 1}); 
                }
            }
        }
    }
}