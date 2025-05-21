import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            a = a % 10;

            if (a == 0) {
                System.out.println(10);
                continue;
            }

            // a^b 의 끝자리 주기를 저장
            int[] pattern = new int[4];
            pattern[0] = a;
            for (int i = 1; i < 4; i++) {
                pattern[i] = (pattern[i - 1] * a) % 10;
            }

            int index = (b - 1) % 4;
            int result = pattern[index];

            // 끝자리가 0이면 컴퓨터 번호는 10번
            if (result == 0)
                result = 10;

            System.out.println(result);
        }

        sc.close();
    }
}