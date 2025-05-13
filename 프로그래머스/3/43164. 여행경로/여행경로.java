import java.util.*;

class Solution {
    static List<String[]> results;
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        results = new ArrayList<>();
        visited = new boolean[tickets.length];

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                String[] path = new String[tickets.length + 1];
                path[0] = "ICN";
                dfs(0, i, path, tickets);
            }
        }

        results.sort((a, b) -> {
            for (int i = 0; i < a.length; i++) {
                int cmp = a[i].compareTo(b[i]);
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return results.get(0);
    }

    private static void dfs(int depth, int curIdx, String[] path, String[][] tickets) {
        if (visited[curIdx]) return;

        path[depth + 1] = tickets[curIdx][1];
        visited[curIdx] = true;

        if (depth + 1 == tickets.length) {
            results.add(path.clone()); 
            visited[curIdx] = false;
            return;
        }

        String next = tickets[curIdx][1];
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(next)) {
                dfs(depth + 1, i, path, tickets);
            }
        }

        visited[curIdx] = false;
    }
}
