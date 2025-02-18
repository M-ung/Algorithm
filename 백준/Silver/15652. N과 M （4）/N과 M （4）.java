import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        backtrack(0, 1);
        System.out.print(sb);
    }

    private static void backtrack(int depth, int start) {
        if (depth == m) {
            // 수열이 완성되었을 때 출력
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i); 
            backtrack(depth + 1, i); 
            list.remove(list.size() - 1);  
        }
    }
}