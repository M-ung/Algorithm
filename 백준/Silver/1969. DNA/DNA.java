import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int distance;
    public static char[] answer;
    public static char[][] dnas;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new char[m];
        dnas = new char[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String dna = st.nextToken();
            dnas[i] = dna.toCharArray();
        }

        for(int i=0; i<m; i++) {
            int ACount = 0;
            int TCount = 0;
            int GCount = 0;
            int CCount = 0;
            char result = ' ';
            for(int j=0; j<n; j++) {
                switch(dnas[j][i]) {
                    case 'A':
                        ACount++;
                        break;
                    case 'T':
                        TCount++;
                        break;
                    case 'G':
                        GCount++;
                        break;
                    case 'C':
                        CCount++;
                        break;
                }
            }
            answer[i] = checkResult(Math.max(Math.max(ACount, TCount), Math.max(GCount, CCount)), CCount, result, GCount, TCount, ACount);
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dnas[j][i] != answer[i]) {
                    distance++;
                }
            }
        }
        print();
    }
    private static char checkResult(int max, int CCount, char result, int GCount, int TCount, int ACount) {
        if(max == TCount) {
            result = 'T';
        }
        if(max == GCount) {
            result = 'G';
        }
        if(max == CCount) {
            result = 'C';
        }
        if(max == ACount) {
            result = 'A';
        }
        return result;
    }

    private static void print() {
        for(char ans : answer) {
            System.out.print(ans);
        }
        System.out.println();
        System.out.println(distance);
    }
}