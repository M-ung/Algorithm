import java.util.*;
class Solution {
    public static int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers[0], target, numbers);
        dfs(0, numbers[0] * (-1), target, numbers);
        return count;
    }
    private static void dfs(int depth, int sum, int target, int[] numbers) {
        if(depth == numbers.length - 1) {
            if(sum == target) {
                count++;
            }
            return;
        }
        dfs(depth+1, sum + numbers[depth+1], target, numbers);
        dfs(depth+1, sum - numbers[depth+1], target, numbers);
    }
    
}