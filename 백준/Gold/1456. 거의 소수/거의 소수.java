import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long Min = sc.nextLong();
        long Max = sc.nextLong();
        long[] arr = new long[10000001];

        for(int i=2; i<arr.length; i++) {
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(arr.length); i++) {
            if(arr[i] == 0) {
                continue;
            }
            for(int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        int count = 0;
        for(int i=2; i < 10000001; i++) {
            if(arr[i] != 0) {
                long temp = arr[i];

                while((double)arr[i] <= (double)Max/(double)temp) {
                    if((double)arr[i] >= (double)Min/(double)temp) {
                        count++;
                    }
                    temp = temp * arr[i];
                }
            }
        }
        System.out.println(count);
    }
}
