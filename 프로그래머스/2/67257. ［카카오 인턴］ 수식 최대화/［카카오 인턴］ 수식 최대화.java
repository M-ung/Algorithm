import java.util.*;

class Solution {
    public static final String[][] operations = {
        {"+", "-", "*"},
        {"+", "*", "-"},
        {"-", "+", "*"},
        {"-", "*", "+"},
        {"*", "+", "-"},
        {"*", "-", "+"}
    };

    public long solution(String expression) {
        List<String> exp = insert(expression);
        long max = -999;
        for(int i=0; i<operations.length; i++) {
            String[] operation = operations[i];
            List<String> expCopy = new ArrayList<>(exp);
            long result = Math.abs(start(operation, expCopy));
            if(result > max) {
                max = result;
            }
        }
        return max;
    }
    
private static long start(String[] operation, List<String> exp) {
    for (int i = 0; i < operation.length; i++) {
        String nowOper = operation[i];
        int j = 0; 
        while (j < exp.size()) { 
            if (exp.get(j).equals(nowOper)) {
                long cal = cal(exp.get(j - 1), exp.get(j + 1), exp.get(j));
                exp.remove(j);   
                exp.remove(j - 1); 
                exp.remove(j - 1); 
                exp.add(j - 1, Long.toString(cal)); 
                
                j--; 
            } else {
                j++; 
            }
        }
    }
    return Long.parseLong(exp.get(0));
}
    
    private static long cal(String str1, String st2, String oper) {
        long num1 = Long.parseLong(str1);
        long num2 = Long.parseLong(st2);
        long result;
        switch (oper) {
            case "+" :
                result = num1 + num2;
                break;
            case "-" :
                result = num1 - num2;
                break;
            case "*" :
                result = num1 * num2;
                break;
            default:
                result = 0;
        }
        return result;
    }
    private static List<String> insert(String expression) {
        List<String> exp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                exp.add(sb.toString()); 
                exp.add(String.valueOf(ch)); 
                sb = new StringBuilder(); 
            } else {
                sb.append(ch); 
            }
        }
        exp.add(sb.toString()); 
        return exp;
    }
}