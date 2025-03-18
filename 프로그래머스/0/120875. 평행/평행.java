import java.util.*;

// 0, 1, 2, 3
// 0, 1 vs 2, 3
// 0, 2 vs 1, 3
// 0, 3 vs 1, 2

class Solution {
    public int solution(int[][] dots) {        
        // 0, 1 vs 2, 3
        if(check(dots[0], dots[1]) == check(dots[2], dots[3])) { return 1; };
        
        // 0, 2 vs 1, 3
        if(check(dots[0], dots[2]) == check(dots[1], dots[3])) { return 1; };
        
        // 0, 3 vs 1, 2
        if(check(dots[0], dots[3]) == check(dots[1], dots[2])) { return 1; };
        
        return 0;
    }
    
    private double check(int[] dot1, int[] dot2) {
        int x1 = dot1[0];
        int y1 = dot1[1];
        int x2 = dot2[0];
        int y2 = dot2[1];
        
        return (double) (y2 - y1) / (x2 - x1);
    }
}