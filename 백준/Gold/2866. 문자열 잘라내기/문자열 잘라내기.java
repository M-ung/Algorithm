import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];

        for(int i=0; i<r; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
        }

        StringBuilder[] columns = new StringBuilder[c];
        for (int i = 0; i < c; i++) {
            columns[i] = new StringBuilder();
            for (int j = 0; j < r; j++) {
                columns[i].append(map[j][i]);
            }
        }

        int count = 0;
        for (int remove = 0; remove < r; remove++) {
            HashSet<String> set = new HashSet<>();

            for (int i = 0; i < c; i++) {
                if (columns[i].length() > remove) {
                    set.add(columns[i].substring(remove));
                }
            }
            if (set.size() != c) {
                break;
            }
            count++;
        }

        System.out.println(count-1);
    }
}