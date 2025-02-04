import java.util.*;

class Solution {
    public static final char[] alp = "AEIOU".toCharArray();
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate(words, "");
        return words.indexOf(word);
    }
    public void generate(List<String> words, String word) {
        words.add(word);
        
        if(word.length() == 5) return;
        for(char c : alp) {
            generate(words, word+c);
        }
    } 
}