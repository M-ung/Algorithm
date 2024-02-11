import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int checkArray[]; // 최소 체크 값
    static int curArray[]; // 현재 값
    static int check = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;
        char arr[] = new char[S];
        checkArray = new int[4];
        curArray = new int[4];

        arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++) {
            checkArray[i] = Integer.parseInt(st.nextToken());
            if(checkArray[i] == 0) {
                check++;
            }
        }

        for(int i=0; i<P; i++) {
            add(arr[i]);
        }

        if(check == 4) count++;

        for(int i=P; i<S; i++) {
            int j= i-P;
            add(arr[i]);
            remove(arr[j]);

            if(check == 4) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void add(char c) {
        switch (c) {
            case 'A' :
                curArray[0]++;
                if(curArray[0] == checkArray[0]) {
                    check++;
                }
                break;
            case 'C' :
                curArray[1]++;
                if(curArray[1] == checkArray[1]) {
                    check++;
                }
                break;
            case 'G' :
                curArray[2]++;
                if(curArray[2] == checkArray[2]) {
                    check++;
                }
                break;
            case 'T' :
                curArray[3]++;
                if(curArray[3] == checkArray[3]) {
                    check++;
                }
                break;
        }
    }
    private static void remove(char c) {
        switch (c) {
            case 'A' :
                if(curArray[0] == checkArray[0]) {
                    check--;
                }
                curArray[0]--;
                break;
            case 'C' :
                if(curArray[1] == checkArray[1]) {
                    check--;
                }
                curArray[1]--;
                break;
            case 'G' :
                if(curArray[2] == checkArray[2]) {
                    check--;
                }
                curArray[2]--;
                break;
            case 'T' :
                if(curArray[3] == checkArray[3]) {
                    check--;
                }
                curArray[3]--;
                break;
        }
    }
}
