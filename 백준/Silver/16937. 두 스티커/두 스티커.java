import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int H;
    static int W;
    static int N;
    static int[][] stickers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        stickers = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        int sum = 0; // 넓이 합
        int max = 0; // 최대 넓이
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(stickers[i][0] + stickers[j][0] <= H && Math.max(stickers[i][1], stickers[j][1]) <= W ||
                        stickers[i][0] + stickers[j][0] <= W && Math.max(stickers[i][1], stickers[j][1]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                }
                else if(stickers[i][0] + stickers[j][1] <= H && Math.max(stickers[i][1], stickers[j][0]) <= W ||
                        stickers[i][0] + stickers[j][1] <= W && Math.max(stickers[i][1], stickers[j][0]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                }
                else if(stickers[i][1] + stickers[j][0] <= H && Math.max(stickers[i][0], stickers[j][1]) <= W ||
                        stickers[i][1] + stickers[j][0] <= W && Math.max(stickers[i][0], stickers[j][1]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                }
                else if(stickers[i][1] + stickers[j][1] <= H && Math.max(stickers[i][0], stickers[j][0]) <= W ||
                        stickers[i][1] + stickers[j][1] <= W && Math.max(stickers[i][0], stickers[j][0]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                }
                if(max < sum) max = sum;
            }
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
