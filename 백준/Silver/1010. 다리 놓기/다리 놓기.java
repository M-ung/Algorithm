import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			long result = 1;
			for(int j=0; j<N; j++)
			{
				result *=(M-j);
				result /= (j+1);
			}
			System.out.println(result);
		}
	}
}