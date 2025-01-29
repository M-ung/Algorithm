class Solution {
    boolean solution(String s) {
        boolean answer;

        int countP = 0;
        int countY = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                countP++;
            }
            if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                countY++;
            }
        }
        if(countP == countY) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}