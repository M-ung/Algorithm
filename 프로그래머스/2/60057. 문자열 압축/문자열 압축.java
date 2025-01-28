import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1001;
        if(s.length() == 1) {
            return 1;
        }
        for(int i=1; i<s.length(); i++) {
            List<String> tokens = new ArrayList<>();
            for (int j = 0; j < s.length(); j += i) { 
                int end = Math.min(j + i, s.length());
                String token = s.substring(j, end);
                tokens.add(token);
            }
            String last = tokens.get(0);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int j=1; j<tokens.size(); j++) {
                if(last.equals(tokens.get(j))) {
                    count++;
                } else {
                    if(count != 1) {
                        sb.append(count);
                    }
                    sb.append(last);
                    count = 1;
                    last = tokens.get(j);
                }
                if (j == tokens.size() -1) {
                    if(count != 1) {
                        sb.append(count);
                    }
                    sb.append(last);
                }
            }
            if(sb.length() != 0) {
                if(answer > sb.toString().length()) {
                    answer = sb.toString().length();
                }
            }
        }
        return answer;
    }
}