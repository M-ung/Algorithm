import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String A;
    static int B;
    static int[] array;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = Integer.parseInt(st.nextToken());
        array = new int[A.length()];
        visited = new boolean[A.length()];

        for(int i=0; i<array.length; i++) {
            array[i] = A.charAt(i) - '0';
        }

        Arrays.sort(array);
        max = -1;

        cal(0, 0, visited);

        System.out.println(max);
    }
    private static void cal(int nowNumber, int count, boolean[] visited) {
        if(count == A.length()) {
            if(max < nowNumber) {
                max = nowNumber;
            }
            return;
        }
        for (int i = 0; i < A.length(); i++) {
            if (visited[i] || (array[i] == 0 && count == 0))
                continue;
            if (nowNumber * 10 + array[i] > B)
                continue;
            visited[i] = true;
            cal(nowNumber * 10 + array[i], count + 1, visited);
            visited[i] = false;
        }
    }
}
