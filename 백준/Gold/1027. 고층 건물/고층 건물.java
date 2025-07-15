import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int visible;
    static int[] heights;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            visible = 0;
            for (int j = i - 1; j >= 0; j--) {
                visible = checkCanSee(i, j);
            }
            for (int j = i + 1; j < N; j++) {
                visible = checkCanSee(j, i);
            }
            answer = Math.max(answer, visible);
        }
        System.out.println(answer);
    }

    private static int checkCanSee(int i, int j) {
        boolean canSee = true;
        for (int k = j + 1; k < i; k++) {
            long dy1 = heights[i] - heights[j];
            long dx1 = i - j;
            long dy2 = heights[k] - heights[j];
            long dx2 = k - j;
            if (dy2 * dx1 >= dy1 * dx2) {
                canSee = false;
                break;
            }
        }
        if (canSee) visible++;
        return visible;
    }
}