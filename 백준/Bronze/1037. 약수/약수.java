import java.util.Random;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		int[] num = new int[N];
		for(int i=0; i<N; i++)
		{
			num[i]=sc.nextInt();
		}
		Arrays.sort(num);
		if(num.length==1)
		{
			int result = num[0]*num[0];
			System.out.println(result);
		}
		else
		{
			int result = num[0]*num[N-1];
			System.out.println(result);
		}
	}

}