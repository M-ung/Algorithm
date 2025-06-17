import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] tree;
    static int n, root, target, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        target = Integer.parseInt(br.readLine());

        if (target == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(count);
        }
    }

    private static void dfs(int node) {
        if (node == target) return;

        int childCount = 0;
        for (int child : tree[node]) {
            if (child != target) {
                dfs(child);
                childCount++;
            }
        }

        if (childCount == 0) {
            count++;
        }
    }
}