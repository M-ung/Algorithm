import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        for(int i=0; i<=N; i=i+4)
        {
            if(i==N)
            {
                System.out.println("int");
            }
            else{
                System.out.print("long ");
            }
        }
    }
}
