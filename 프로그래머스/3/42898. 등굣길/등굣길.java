class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1]; 
        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1; 
        }
        dp[1][1] = 1; 
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                if (x == 1 && y == 1) continue; 
                if (dp[x][y] == -1) { 
                    dp[x][y] = 0; 
                    continue;
                }
                if (x > 1) dp[x][y] += dp[x-1][y]; 
                if (y > 1) dp[x][y] += dp[x][y-1]; 
                dp[x][y] %= 1000000007;
            }
        }
        return dp[m][n];
    }
}