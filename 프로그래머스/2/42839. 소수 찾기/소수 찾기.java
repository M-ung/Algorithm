import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String numbers) {
        Set<String> result = new HashSet<>();  
        boolean[] visited = new boolean[numbers.length()];
        generatePermutations("", numbers, visited, result);

        int count = 0;
        for (String numStr : result) {
            int number = Integer.parseInt(numStr);
            if (check(number)) {
                System.out.println("check :" + number);
                count++;
            }
        }
        return count;
    }
    
    
    private static void generatePermutations(String prefix, String numbers, boolean[] visited, Set<String> result) {
        if (!prefix.isEmpty() && prefix.charAt(0) != '0') { 
            result.add(prefix); 
        } 

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(prefix + numbers.charAt(i), numbers, visited, result);
                visited[i] = false;
            }
        }
    }
    
    private static Boolean check(int number) {
        int count = 0;
        for(int i=1; i<=number; i++) {
            if(number % i == 0) { count++; }
        }
        if(count == 2) {
            return true;
        }
        return false;
    }
}