import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int s;
    public static int count;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        for(int i = 0; i < n; i++) {
            dfs(arr[i], i);
        }

        System.out.println(count);
    }

    private static void dfs(int sum, int index) {
        if(index == arr.length) return;

        if(sum == s) {
            count++;
        }

        for (int i = index + 1; i < n; i++) {
            dfs(sum + arr[i], i);
        }
    }
}