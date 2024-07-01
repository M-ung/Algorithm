import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] answer;
    static int[] parent;
    public static ArrayList<Integer>[] party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int count_know = Integer.parseInt(st.nextToken());

        if(count_know == 0) {
            System.out.println(m);
            return;
        }

        answer = new int[count_know];

        for(int i=0; i<count_know; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n + 1];
        party = new ArrayList[m];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) { 
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int party_size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < party_size; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < m; i++) {
            int first_man = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(first_man, party[i].get(j));
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int leader = party[i].get(0);
            boolean flag = true;
            for (int j = 0; j < count_know; j++) {
                if (check(leader, answer[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
        }
    }
    public static boolean check(int a, int b) {
        if (find(a) == find(b)) { // 같은 집합에 속한다면 true
            return true;
        } else return false;
    }
}
