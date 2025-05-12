class Solution {
    static long[] memo;
    public long solution(int n) {
        memo = new long[n + 1];  
        return dfs(n);
    }
    private static long dfs(int n) {
        if (n == 0) return 1;  
        if (n == 1) return 1;  

        if (memo[n] != 0) return memo[n];

        memo[n] = (dfs(n - 1) + dfs(n - 2)) % 1234567; 
        return memo[n];
    }
}