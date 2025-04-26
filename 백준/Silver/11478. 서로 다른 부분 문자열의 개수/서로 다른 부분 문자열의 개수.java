import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static String s;
    public static char[] array;
    public static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        array = s.toCharArray();
        set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            String s = "";
            dfs(i, s+array[i]);
        }
        System.out.println(set.size());
    }
    private static void dfs(int depth, String current) {
        if(depth == array.length) return;

        current += array[depth];
        set.add(current);
        dfs(depth + 1, current);
    }
}