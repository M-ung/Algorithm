import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        check = new boolean[988];
        for (int i=123; i<=987; i++) {
            String num = String.valueOf(i);
            if(num.charAt(0) == '0' || num.charAt(1) == '0' || num.charAt(2) == '0') continue;
            if(num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2)) continue;
            check[i] = true;
        }
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for(int j=123; j<=987; j++) {
                if(check[j]) {
                    int[] result = getStrikeAndBall(num, j);
                    if (result[0] != strike || result[1] != ball) {
                        check[j] = false; 
                    }
                }
            }
        }

        int count= 0;
        for (int i=123; i<=987; i++) {
            if(check[i]) count++;
        }
        System.out.println(count);
    }

    private static int[] getStrikeAndBall(int num1, int num2) {
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                strike++;
            } else if (s2.contains(String.valueOf(s1.charAt(i)))) {
                ball++;
            }
        }

        return new int[]{strike, ball};
    }
}
