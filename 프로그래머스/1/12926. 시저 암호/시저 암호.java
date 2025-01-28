
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(shift(c, n));
        }
        return sb.toString();
    }

    private char shift(char c, int n) {
        if (c == ' ') {
            return ' ';
        }
        
        if (c >= 'A' && c <= 'Z') {
            return (char) ((c - 'A' + n) % 26 + 'A');
        }
        
        if (c >= 'a' && c <= 'z') {
            return (char) ((c - 'a' + n) % 26 + 'a');
        }
    
        return c;
    }
}