import java.util.*;
class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    public int solution(int n) {
        return fibonacci(n);
    }
    private int fibonacci(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n); 
        int result = (fibonacci(n - 1) + fibonacci(n - 2))%1234567;
        memo.put(n, result); 
        return result;
    }
}