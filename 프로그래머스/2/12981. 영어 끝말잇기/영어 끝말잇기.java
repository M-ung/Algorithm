import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> hash = new HashSet<>();
        
        int who = -1;
        
        for(int i=0; i<words.length; i++) {
            if(i > 0) {
                char p = words[i - 1].charAt(words[i - 1].length() - 1);
                char c = words[i].charAt(0);
                if(p != c) {
                    who = i+1;
                    break;
                }
            } 
            if(words[i].length() == 1) {
                who = i+1;
                break;
            }
            if(hash.contains(words[i])) {
                who = i+1;
                break;
            } else {
                hash.add(words[i]);
            }
        }

        if(who == -1) {
            return new int[] {0, 0};
        } else {
            System.out.println(who);
            return new int[] {who % n == 0 ? n : who % n, (int) Math.ceil((double) who / n)};
        }
    }
}