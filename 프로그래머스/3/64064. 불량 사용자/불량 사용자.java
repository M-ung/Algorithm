import java.util.*;

class Solution {
    private Set<Set<String>> uniqueCombinations = new HashSet<>(); 

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> possibleMatches = new ArrayList<>();
        
        for (String banned : banned_id) {
            String regex = banned.replace("*", ".");
            List<String> matched = new ArrayList<>();
            for (String id : user_id) {
                if (id.matches(regex)) {  
                    matched.add(id);
                }
            }
            possibleMatches.add(matched);
        }

        findCombinations(new HashSet<>(), 0, possibleMatches);
        
        return uniqueCombinations.size();
    }

    private void findCombinations(Set<String> currentSet, int index, List<List<String>> possibleMatches) {
        if (index == possibleMatches.size()) {  
            uniqueCombinations.add(new HashSet<>(currentSet));
            return;
        }

        for (String user : possibleMatches.get(index)) {
            if (!currentSet.contains(user)) {
                currentSet.add(user);
                findCombinations(currentSet, index + 1, possibleMatches);
                currentSet.remove(user);
            }
        }
    }
}