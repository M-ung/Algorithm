import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X;
    static int result;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[N];

        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        cal(0, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println(result);
    }
    private static void cal(int index, int count, int nowNumber, int max, int min) {
        if(count >= 2) {
            if (nowNumber >= L && nowNumber <= R && max - min >= X) {
                result += 1;
            }
        }
        for (int i = index; i < N; i++) {
            cal(i+1,count+1, nowNumber + array[i], Math.max(max, array[i]), Math.min(min, array[i]));
        }
    }
}
