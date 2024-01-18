import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 후라이드 치킨 가격
        int B = Integer.parseInt(st.nextToken()); // 양념 치킨 가격
        int C = Integer.parseInt(st.nextToken()); // 반반 치킨 가격
        int X = Integer.parseInt(st.nextToken()); // 후라이드 치킨 수량
        int Y = Integer.parseInt(st.nextToken()); // 양념 치킨 수량

        int sum = 0;

        while(X > 0 || Y > 0) { // 후라이드 개수와 양념 개수가 모두 0 마리 이하가 될 때까지 반복한다.
            if ((A + B >= 2 * C) && (X >= 1) && (Y >= 1)) { // 후 + 양 >= 2 * 반반이고 각각 한 마리 이상 있을 때,
                int count_C = Math.min(X, Y); // 후라이드와 양념 중 최소 개수를 각가에 빼준다.
                sum = sum + C * 2 * count_C;
                X = X - count_C;
                Y = Y - count_C;
//                System.out.println("sum1 = " + sum);
            }
            else { // 후 + 양 < 2 * 반반 일 때,
                if(A >= 2 * C && X >= 1) { // 후 >= 2 * 반반 일 때,
                    sum = sum + C * X * 2;
                    X = 0;
//                    array[3] = array[3] - count_C;
//                    System.out.println("sum2 = " + sum);
                } else {
                    if(X != 0) {
                        sum = sum + A * X;
                        X = 0;
//                        System.out.println("sum3 = " + sum);
                    }
                }
                if(B >= 2 * C && Y >= 1) { // 양 >= 2 * 반반 일 때,
                    int count_C = Y;
                    sum = sum + C * count_C * 2;
                    Y = 0;
//                    System.out.println("sum4 = " + sum);
                } else {
                    if(Y != 0) {
                        sum = sum + B * Y;
                        Y = 0;
//                        System.out.println("sum5 = " + sum);
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
