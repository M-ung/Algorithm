import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n][n];
        
        for(int i=0; i<results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            graph[win-1][lose-1] = true;
        }
        
        for(int i=0; i<graph.length; i++) {
            int goCount = go(i, graph, new boolean[n]) - 1;
            int backCount = back(i, graph, new boolean[n]) - 1;
            if(goCount+backCount+1 == n) {
                answer++;
            } 
        }
        
        return answer;
    }
    private int go(int u, boolean[][] graph, boolean[] visited) {
        int count = 1;
        for(int v=0; v<graph[u].length; v++) {
            if(!graph[u][v] || visited[v]) continue;
            visited[v] = true;
            count += go(v, graph, visited);
        }
        return count;
    }
    private int back(int u, boolean[][] graph, boolean[] visited) {
        int count = 1;
        for(int v=0; v<graph[u].length; v++) {
            if(!graph[v][u] || visited[v]) continue;
            visited[v] = true;
            count += back(v, graph, visited);
        }
        return count;
    }
}