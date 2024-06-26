import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static node[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new node[n+1];

        for(int i=0; i<=n; i++) {
            arr[i] = new node(i, i);
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(q ==  0) {
                union(a, b);
            }
            else if(q == 1) {
                if(checkSame(a, b)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }
    private static void union(int index_a, int index_b) {
        index_a = find(index_a);
        index_b = find(index_b);
        if(index_a != index_b) {
            arr[index_b].value = index_a;
        }
    }
    private static int find(int index) {
        if(index == arr[index].value)
            return index;
        else
            return arr[index].value = find(arr[index].value);
    }

    private static boolean checkSame(int index_a, int index_b) {
        index_a = find(index_a);
        index_b = find(index_b);
        if(index_a == index_b) {
            return true;
        } else {
            return false;
        }
    }
}
class node {
    int index;
    int value;

    public node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}