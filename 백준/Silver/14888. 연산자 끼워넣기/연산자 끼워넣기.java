import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Long> a;
    public static int[] operations;
    public static long max = Long.MIN_VALUE;
    public static long min = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        a = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a.add(Long.parseLong(st.nextToken()));
        }

        operations = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(a, operations);

        System.out.println(max);
        System.out.println(min);
    }

    private static void backtrack(List<Long> a, int[] operations) {
        if(operations[0] == 0 &&  operations[1] == 0 &&  operations[2] == 0 &&  operations[3] == 0) {
            long result =  a.get(0);
            if(result > max) {
                max = result;
            } if(result < min) {
                min = result;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (operations[i] != 0) {
                operations[i]--;
                long num1 = a.get(0);
                long num2 = a.get(1);
                long result = calculator(num1, num2, i);
                a.remove(0);  
                a.set(0, result);
                backtrack(a, operations);
                a.set(0, num2);  
                a.add(0, num1);  
                operations[i]++;
            }
        }
    }

    private static long calculator(long num1, long num2, int operationIndex) {
        switch (operationIndex) {
            case 0:
                return num1 + num2;
            case 1:
                return num1 - num2;
            case 2:
                return num1 * num2;
            case 3:
                if((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0)) {
                    return (Math.abs(num1) / Math.abs(num2)) * (-1);
                }
                return num1 / num2;
            default:
                return 0;
        }
    }
}
