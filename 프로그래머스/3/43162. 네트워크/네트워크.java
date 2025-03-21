class Solution {
    public static int count = 0;
    public static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, computers, visited);
                count++;
            }
        }
        return count;
    }
    private static void dfs(int i, int[][] computers, boolean[] visited) {
        visited[i] = true;
        for(int j=0; j<computers.length; j++) {
            if(!visited[j] && computers[i][j]==1) {
                dfs(j, computers, visited);
            }
        }
    }
}