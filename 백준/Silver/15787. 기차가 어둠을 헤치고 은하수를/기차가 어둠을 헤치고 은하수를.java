import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] train = new int[n];
        for (int i = 0; i < n; i++) {
            train[i] = 0;
        }
        for (int c = 0; c < m; c++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i, x;
            switch (command) {
                case 1:
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    train[i-1] |= (1 << (x-1));
                    break;
                case 2:
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());
                    train[i-1] &= ~(1 << (x - 1));
                    break;
                case 3:
                    i = Integer.parseInt(st.nextToken());
                    train[i-1] = (train[i-1] << 1) & ((1 << 20) - 1);
                    break;
                case 4:
                    i = Integer.parseInt(st.nextToken());
                    train[i-1] = train[i-1] >> 1;
                    break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(train[i]);
        }
        System.out.println(set.size());
    }
}