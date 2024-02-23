import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] tmp;
    static long count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        tmp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        merge_sort(1, N);

        bw.write(count+"");
        bw.flush();
        bw.close();
    }

    private static void merge_sort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int m = start + (end - start) / 2;

        merge_sort(start, m);
        merge_sort(m+1, end);

        for(int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }

        int k = start;
        int index1 = start;
        int index2 = m + 1;

        while (index1 <= m && index2 <= end) {
            if(tmp[index1] > tmp[index2]) {
                arr[k] = tmp[index2];
                count = count + index2 - k;
                k++;
                index2++;
            } else {
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= end) {
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
