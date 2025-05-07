import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, String> graph;
    static Set<String> visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int caseNum = 1;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if(t == 0) break;

            graph = new HashMap<>();
            visited = new HashSet<>();

            for (int i = 0; i < t; i++) {
                String[] names = br.readLine().split(" ");
                graph.put(names[0], names[1]);
            }

            int chainCount = 0;
            for (String name : graph.keySet()) {
                if (!visited.contains(name)) {
                    dfs(name);
                    chainCount++;
                }
            }

            System.out.println(caseNum + " " + chainCount);
            caseNum++;
        }
    }
    static void dfs(String name) {
        while (!visited.contains(name)) {
            visited.add(name);
            name = graph.get(name);
        }
    }
}