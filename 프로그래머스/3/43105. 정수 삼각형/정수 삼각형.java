import java.util.*;

class Solution {
    private int[][] memo;
    public int solution(int[][] triangle) {
        int n = triangle.length;
        memo = new int[n][n]; 
        for (int[] row : memo) Arrays.fill(row, -1);
        return track(0, 0, triangle);
    }
    private int track(int x, int y, int[][] triangle) {
        if (x == triangle.length) return 0; 
        if (memo[x][y] != -1) return memo[x][y]; 
        int left = track(x + 1, y, triangle);  
        int right = track(x + 1, y + 1, triangle);
        return memo[x][y] = triangle[x][y] + Math.max(left, right);   
    }
}
//7
//3 8
//8 1 0
//2 7 4 4
//4 5 2 6 5

//i는 +1 로, j는 그대로 or +1