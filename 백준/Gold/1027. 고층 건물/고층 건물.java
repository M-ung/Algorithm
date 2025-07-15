import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
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
            int visible = 0;

            // 왼쪽
            for (int j = i - 1; j >= 0; j--) {
                boolean canSee = true;
                for (int k = j + 1; k < i; k++) {
                    // j ~ i 직선에 대해, 중간 건물 k가 위에 있는지 판단
                    long dy1 = heights[i] - heights[j];
                    long dx1 = i - j;
                    long dy2 = heights[k] - heights[j];
                    long dx2 = k - j;
                    // dy2/dx2 >= dy1/dx1 이면, 시야 차단
                    if (dy2 * dx1 >= dy1 * dx2) {
                        canSee = false;
                        break;
                    }
                }
                if (canSee) visible++;
            }

            // 오른쪽
            for (int j = i + 1; j < N; j++) {
                boolean canSee = true;
                for (int k = i + 1; k < j; k++) {
                    long dy1 = heights[j] - heights[i];
                    long dx1 = j - i;
                    long dy2 = heights[k] - heights[i];
                    long dx2 = k - i;
                    if (dy2 * dx1 >= dy1 * dx2) {
                        canSee = false;
                        break;
                    }
                }
                if (canSee) visible++;
            }

            answer = Math.max(answer, visible);
        }

        System.out.println(answer);
    }
} 