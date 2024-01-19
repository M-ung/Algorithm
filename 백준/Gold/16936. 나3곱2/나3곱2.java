import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visit;
    static boolean complete = false;
    static ArrayList<Long> arrayList = new ArrayList<>();;
    static long[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        answer = new long[N];
        visit = new boolean[N]; // 방문한 곳 확인

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arrayList.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(arrayList); // 오름차순

        for (int i = 0; i < N; i++) {
            if (complete) {
                break;
            }
            cal(0, i);
        }

        //결과로 얻은 순서 BufferedWriter 저장
        for (int i = 0; i < N; i++)
        {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void cal(int count, int index) {
        if(answer[N-1]!=0) {		//올바른 순서 찾았을 때
            complete = true;		//완성!
            return;
        }

        if(!visit[index]) {
            visit[index] = true;
            answer[count] = arrayList.get(index);
            if(arrayList.get(index) % 3 == 0) {
                for (int i = index - 1; i >= 0; i--) {
                    if(arrayList.get(index) / 3 == arrayList.get(i)){
                        cal(count+1, i);
                        break;
                    }
                }
            }
            long temp = arrayList.get(index) * 2;
            for(int i = index + 1; i < N; i++) {
                if(temp == arrayList.get(i)){
                    cal(count+1, i);
                    break;
                }
            }
        }
        visit[index] = false;
    }
}