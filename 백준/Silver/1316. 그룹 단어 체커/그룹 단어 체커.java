import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str ="";
        int count=0;
        int prev=0;
        for(int i=0; i<N; i++)
        {
            boolean [] check = new boolean[26];
            str = sc.next();
            for(int j=0; j<str.length(); j++)
            {
                int index = str.charAt(j) - 'a';
                if(check[index])
                {
                    if(index!=prev)
                    {
                        break;
                    }
                }
                else {
                    check[index]=true;
                }
                prev=index;
                if(j==str.length()-1)
                {
                    count++;
                }

            }
        }
        System.out.println(count);
    }
}