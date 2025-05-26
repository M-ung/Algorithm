import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result;

        if (N == 0) {
            result = 0;
        }
        else if (N == 1) {
            result = 0;
        } else if (N == 2) {
            result = 1;
        } else if (N == 3) {
            result = 3;
        } else {
            result = 3 * N - 4;
        }

        System.out.println(result);
    }
}